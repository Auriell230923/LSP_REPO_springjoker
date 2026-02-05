package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ETLPipeline {

    public static void main(String[] args) {
        String inputFile = "data/products.csv";
        String outputFile = "data/transformed_products.csv";

        int rowsRead = 0;        // non-header lines encountered (includes bad ones)
        int rowsTransformed = 0; // valid rows written
        int rowsSkipped = 0;     // invalid/blank rows skipped

        // Missing file case (must exit cleanly)
        File f = new File(inputFile);
        if (!f.exists()) {
            System.out.println("ERROR: Missing input file (data/products.csv).");
            return;
        }

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader(inputFile));
            bw = new BufferedWriter(new FileWriter(outputFile));

            // Always write header row to output
            bw.write("ProductID,Name,Price,Category,PriceRange");
            bw.newLine();

            // Read input header (do not transform)
            String header = br.readLine();

            // Empty input file (no lines at all)
            if (header == null) {
                // Output already has header row
                printSummary(rowsRead, rowsTransformed, rowsSkipped, outputFile);
                return;
            }

            String line;
            while ((line = br.readLine()) != null) {
                rowsRead++;

                // Skip blank lines
                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                // Split and validate field count
                String[] parts = line.split(",");
                if (parts.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                // Trim each field
                String idStr = parts[0].trim();
                String name = parts[1].trim();
                String priceStr = parts[2].trim();
                String category = parts[3].trim();

                int productId;
                BigDecimal price;

                // Parse ProductID + Price (skip row if bad)
                try {
                    productId = Integer.parseInt(idStr);
                    price = new BigDecimal(priceStr);
                } catch (Exception e) {
                    rowsSkipped++;
                    continue;
                }

                // ----------------------------
                // TRANSFORM (exact order)
                // ----------------------------

                // 1) Name to UPPERCASE
                name = name.toUpperCase();

                // Save original category check
                boolean originalWasElectronics = category.equals("Electronics");

                // 2) If Electronics, apply 10% discount
                if (originalWasElectronics) {
                    price = price.multiply(new BigDecimal("0.90"));
                }

                // Round HALF_UP to exactly 2 decimals
                price = price.setScale(2, RoundingMode.HALF_UP);

                // 3) Premium Electronics rule (uses final rounded price + original category)
                if (originalWasElectronics && price.compareTo(new BigDecimal("500.00")) > 0) {
                    category = "Premium Electronics";
                }

                // 4) PriceRange based on final rounded price
                String priceRange;
                if (price.compareTo(new BigDecimal("10.00")) <= 0) {
                    priceRange = "Low";
                } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
                    priceRange = "Medium";
                } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
                    priceRange = "High";
                } else {
                    priceRange = "Premium";
                }

                // ----------------------------
                // LOAD (write to output)
                // ----------------------------
                bw.write(productId + "," + name + "," + price.toPlainString() + "," + category + "," + priceRange);
                bw.newLine();

                rowsTransformed++;
            }

            bw.flush();

        } catch (IOException e) {
            System.out.println("ERROR: Could not read/write files.");
            return;
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ignored) {}

            try {
                if (bw != null) bw.close();
            } catch (IOException ignored) {}
        }

        printSummary(rowsRead, rowsTransformed, rowsSkipped, outputFile);
    }

    private static void printSummary(int read, int transformed, int skipped, String outputFile) {
        System.out.println("Number of rows read: " + read);
        System.out.println("Number of rows transformed: " + transformed);
        System.out.println("Number of rows skipped: " + skipped);
        System.out.println("Output file path written: " + outputFile);
    }
}


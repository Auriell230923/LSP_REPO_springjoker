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

        int rowsRead = 0;        // non-header lines encountered (including bad ones)
        int rowsSkipped = 0;     // bad/blank/wrong-format lines
        int rowsTransformed = 0; // lines written to output

        // 1) Missing file case
        File f = new File(inputFile);
        if (!f.exists()) {
            System.out.println("ERROR: Missing input file: " + inputFile);
            return; // exit cleanly (no stack trace)
        }

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader(inputFile));
            bw = new BufferedWriter(new FileWriter(outputFile));

            // Always write header row to output
            bw.write("ProductID,Name,Price,Category,PriceRange");
            bw.newLine();

            // Read header from input (do not transform)
            String header = br.readLine();

            // If file is totally empty (no header at all), we still created output with header above
            if (header == null) {
                printSummary(rowsRead, rowsTransformed, rowsSkipped, outputFile);
                closeQuietly(br, bw);
                return;
            }

            // Read each non-header line
            String line;
            while ((line = br.readLine()) != null) {
                rowsRead++;

                // skip blank line
                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                // split and validate field count
                String[] parts = line.split(",");
                if (parts.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                // trim each field
                String idStr = parts[0].trim();
                String name = parts[1].trim();
                String priceStr = parts[2].trim();
                String category = parts[3].trim();

                // parse ProductID and Price
                int productId;
                BigDecimal price;

                try {
                    productId = Integer.parseInt(idStr);
                    price = new BigDecimal(priceStr);
                } catch (Exception e) {
                    rowsSkipped++;
                    continue;
                }

                // ----------------------------
                // 2) TRANSFORM (exact order)
                // ----------------------------

                // (1) name to UPPERCASE
                name = name.toUpperCase();

                // Track original category = Electronics before any changes
                boolean originalWasElectronics = category.equals("Electronics");

                // (2) 10% discount if category is Electronics
                if (originalWasElectronics) {
                    price = price.multiply(new BigDecimal("0.90"));
                }

                // Round HALF_UP to exactly 2 decimals
                price = price.setScale(2, RoundingMode.HALF_UP);

                // (3) Premium Electronics rule (uses final rounded price + original category)
                if (originalWasElectronics && price.compareTo(new BigDecimal("500.00")) > 0) {
                    category = "Premium Electronics";
                }

                // (4) PriceRange based on final rounded price
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
                // 3) LOAD (write output row)
                // ----------------------------

                // price.toPlainString() will keep "500.40" etc exactly, and setScale ensures 2 decimals
                bw.write(productId + "," + name + "," + price.toPlainString() + "," + category + "," + priceRange);
                bw.newLine();

                rowsTransformed++;
            }

            // done writing
            bw.flush();

        } catch (IOException e) {
            System.out.println("ERROR: Could not read/write files.");
            // exit cleanly
        } finally {
            closeQuietly(br, bw);
        }

        // Run summary
        printSummary(rowsRead, rowsTransformed, rowsSkipped, outputFile);
    }

    private static void printSummary(int read, int transformed, int skipped, String outputFile) {
        System.out.println("Number of rows read: " + read);
        System.out.println("Number of rows transformed: " + transformed);
        System.out.println("Number of rows skipped: " + skipped);
        System.out.println("Output file path written: " + outputFile);
    }

    private static void closeQuietly(BufferedReader br, BufferedWriter bw) {
        try {
            if (br != null) br.close();
        } catch (IOException ignored) {}

        try {
            if (bw != null) bw.close();
        } catch (IOException ignored) {}
    }
}

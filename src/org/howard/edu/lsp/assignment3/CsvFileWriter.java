package org.howard.edu.lsp.assignment3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Writes transformed products to a CSV file in the required output format.
 */
public class CsvFileWriter {

  private static final String OUTPUT_HEADER = "ProductID,Name,Price,Category,PriceRange";

  /**
   * Writes the transformed products to outputPath with the required header.
   *
   * @param outputPath output CSV path (data/transformed_products.csv)
   * @param products transformed products (may be empty)
   * @throws IOException if an I/O error occurs while writing
   */
  public void writeProducts(String outputPath, List<ProductRecord> products) throws IOException {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {
      bw.write(OUTPUT_HEADER);
      bw.newLine();

      for (ProductRecord p : products) {
        bw.write(p.toOutputCsvLine());
        bw.newLine();
      }
    }
  }
}
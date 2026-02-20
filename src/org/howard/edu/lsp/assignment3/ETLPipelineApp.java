package org.howard.edu.lsp.assignment3;

/**
 * Entry point for Assignment 3 ETL Pipeline.
 * Reads from data/products.csv and writes to data/transformed_products.csv.
 */
public class ETLPipelineApp {

  /**
   * Runs the ETL pipeline using the required relative input/output paths.
   *
   * @param args command-line args (unused)
   */
  public static void main(String[] args) {
    final String inputPath = "data/products.csv";
    final String outputPath = "data/transformed_products.csv";

    ETLPipeline pipeline = new ETLPipeline(
        new CsvFileReader(),
        new CsvFileWriter(),
        new ProductRowParser(),
        new ProductTransformer(new DefaultPriceRangeClassifier())
    );

    pipeline.run(inputPath, outputPath);
  }
}
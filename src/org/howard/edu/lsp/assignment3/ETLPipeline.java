package org.howard.edu.lsp.assignment3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Orchestrates the ETL process (Extract, Transform, Load).
 * Coordinates reading CSV rows, parsing/validating, transforming, and writing output.
 */
public class ETLPipeline {

  private final CsvFileReader reader;
  private final CsvFileWriter writer;
  private final AbstractRowParser<ProductRecord> parser;
  private final Transformer<ProductRecord, ProductRecord> transformer;

  /**
   * Constructs a pipeline with injected dependencies.
   *
   * @param reader reads raw CSV rows
   * @param writer writes output CSV
   * @param parser parses/validates rows into ProductRecord objects
   * @param transformer transforms ProductRecord objects
   */
  public ETLPipeline(
      CsvFileReader reader,
      CsvFileWriter writer,
      AbstractRowParser<ProductRecord> parser,
      Transformer<ProductRecord, ProductRecord> transformer
  ) {
    this.reader = reader;
    this.writer = writer;
    this.parser = parser;
    this.transformer = transformer;
  }

  /**
   * Runs the pipeline from inputPath to outputPath using Assignment 2 requirements.
   *
   * @param inputPath relative path to input CSV (data/products.csv)
   * @param outputPath relative path to output CSV (data/transformed_products.csv)
   */
  public void run(String inputPath, String outputPath) {
    List<CsvRow> rows;
    try {
      rows = reader.readAll(inputPath);
    } catch (FileNotFoundException e) {
      System.out.println("ERROR: Input file not found: " + inputPath);
      return;
    } catch (IOException e) {
      System.out.println("ERROR: Could not read input file: " + e.getMessage());
      return;
    }

    // Empty file OR header-only file => write header-only output.
    if (rows.isEmpty() || (rows.size() == 1 && rows.get(0).isHeaderRow())) {
      try {
        writer.writeProducts(outputPath, new ArrayList<>());
      } catch (IOException e) {
        System.out.println("ERROR: Could not write output file: " + e.getMessage());
      }
      return;
    }

    List<ProductRecord> outputs = new ArrayList<>();

    // Skip header if present
    int startIndex = (rows.get(0).isHeaderRow()) ? 1 : 0;

    for (int i = startIndex; i < rows.size(); i++) {
      CsvRow row = rows.get(i);

      ProductRecord parsed = parser.parse(row);
      if (parsed == null) {
        // invalid row => skip
        continue;
      }

      ProductRecord transformed = transformer.transform(parsed);
      outputs.add(transformed);
    }

    try {
      writer.writeProducts(outputPath, outputs);
    } catch (IOException e) {
      System.out.println("ERROR: Could not write output file: " + e.getMessage());
    }
  }
}
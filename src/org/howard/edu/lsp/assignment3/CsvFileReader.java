package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads CSV files into raw CsvRow objects.
 * Assumes simple comma-separated input (no quoted commas handling).
 */
public class CsvFileReader {

  /**
   * Reads all lines from the CSV file into CsvRow objects.
   *
   * @param inputPath relative path to input CSV
   * @return list of CsvRow objects (may be empty if file is empty)
   * @throws FileNotFoundException if input file does not exist
   * @throws IOException if an I/O error occurs while reading
   */
  public List<CsvRow> readAll(String inputPath) throws IOException {
    List<CsvRow> rows = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(inputPath))) {
      String line;
      while ((line = br.readLine()) != null) {
        rows.add(CsvRow.fromLine(line));
      }
    } catch (FileNotFoundException e) {
      throw e;
    }

    return rows;
  }
}
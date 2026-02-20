package org.howard.edu.lsp.assignment3;

/**
 * Represents one raw CSV row.
 * Encapsulates the original line and provides a simple split into fields.
 */
public class CsvRow {

  private final String rawLine;
  private final String[] fields;

  private CsvRow(String rawLine, String[] fields) {
    this.rawLine = rawLine;
    this.fields = fields;
  }

  /**
   * Creates a CsvRow from a raw input line.
   *
   * @param line raw line from the file
   * @return CsvRow instance
   */
  public static CsvRow fromLine(String line) {
    String safe = (line == null) ? "" : line;
    String[] parts = safe.split(",", -1); // keep empty fields
    return new CsvRow(safe, parts);
  }

  /**
   * Checks if this row looks like the expected header row for Assignment 2.
   *
   * @return true if header, false otherwise
   */
  public boolean isHeaderRow() {
    if (fields.length < 4) return false;
    return "ProductID".equals(fields[0].trim())
        && "Name".equals(fields[1].trim())
        && "Price".equals(fields[2].trim())
        && "Category".equals(fields[3].trim());
  }

  /** @return field count */
  public int size() {
    return fields.length;
  }

  /**
   * Returns the field value at index i.
   *
   * @param i index
   * @return field string (may be empty)
   */
  public String get(int i) {
    return fields[i];
  }

  /** @return original raw line */
  public String raw() {
    return rawLine;
  }
}
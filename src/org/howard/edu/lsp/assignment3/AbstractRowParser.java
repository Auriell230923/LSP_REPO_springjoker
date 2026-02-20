package org.howard.edu.lsp.assignment3;

/**
 * Base class for parsing and validating a CsvRow into a domain object.
 * Demonstrates inheritance: specific parsers extend this base.
 *
 * @param <T> output domain type
 */
public abstract class AbstractRowParser<T> {

  /**
   * Parses a row into a domain object, returning null if invalid.
   *
   * @param row raw CSV row
   * @return parsed object or null if row is invalid
   */
  public final T parse(CsvRow row) {
    if (row == null) return null;
    if (!isValid(row)) return null;
    return convert(row);
  }

  protected abstract boolean isValid(CsvRow row);

  protected abstract T convert(CsvRow row);
}
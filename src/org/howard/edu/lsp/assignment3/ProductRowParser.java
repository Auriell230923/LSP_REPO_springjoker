package org.howard.edu.lsp.assignment3;

/**
 * Parses rows from products.csv into ProductRecord objects.
 * Expected input columns: ProductID, Name, Price, Category
 */
public class ProductRowParser extends AbstractRowParser<ProductRecord> {

  @Override
  protected boolean isValid(CsvRow row) {
    if (row.size() != 4) return false;

    String productIdStr = row.get(0).trim();
    String name = row.get(1).trim();
    String priceStr = row.get(2).trim();
    String category = row.get(3).trim();

    if (productIdStr.isEmpty() || name.isEmpty() || priceStr.isEmpty() || category.isEmpty()) {
      return false;
    }

    try {
      Integer.parseInt(productIdStr);
    } catch (NumberFormatException e) {
      return false;
    }

    try {
      Double.parseDouble(priceStr);
    } catch (NumberFormatException e) {
      return false;
    }

    return true;
  }

  @Override
  protected ProductRecord convert(CsvRow row) {
    int productId = Integer.parseInt(row.get(0).trim());
    String name = row.get(1).trim();
    double price = Double.parseDouble(row.get(2).trim());
    String category = row.get(3).trim();

    return new ProductRecord(productId, name, price, category, null);
  }
}
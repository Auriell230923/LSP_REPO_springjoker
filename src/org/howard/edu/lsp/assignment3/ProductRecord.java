package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Domain model representing a product and its transformed fields.
 */
public class ProductRecord {

  private final int productId;
  private final String name;
  private final double price;
  private final String category;
  private final PriceRange priceRange;

  public ProductRecord(int productId, String name, double price, String category, PriceRange priceRange) {
    this.productId = productId;
    this.name = name;
    this.price = price;
    this.category = category;
    this.priceRange = priceRange;
  }

  public int getProductId() {
    return productId;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public String getCategory() {
    return category;
  }

  public PriceRange getPriceRange() {
    return priceRange;
  }

  public ProductRecord withTransformedFields(String newName, double newPrice, PriceRange newPriceRange) {
    return new ProductRecord(productId, newName, newPrice, category, newPriceRange);
  }

  public String toOutputCsvLine() {
    BigDecimal bd = BigDecimal.valueOf(price).setScale(2, RoundingMode.HALF_UP);
    String pr = (priceRange == null) ? "" : priceRange.toString();
    return productId + "," + name + "," + bd + "," + category + "," + pr;
  }
}
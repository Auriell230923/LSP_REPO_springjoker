package org.howard.edu.lsp.assignment3;

public class DefaultPriceRangeClassifier implements PriceRangeClassifier {

  @Override
  public PriceRange classify(double price) {
    if (price < 10.0) return PriceRange.LOW;
    if (price <= 100.0) return PriceRange.MEDIUM;
    return PriceRange.HIGH;
  }
}
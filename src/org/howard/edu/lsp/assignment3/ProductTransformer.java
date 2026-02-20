package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProductTransformer implements Transformer<ProductRecord, ProductRecord> {

  private final PriceRangeClassifier classifier;

  public ProductTransformer(PriceRangeClassifier classifier) {
    this.classifier = classifier;
  }

  @Override
  public ProductRecord transform(ProductRecord input) {
    String upperName = input.getName().toUpperCase();

    BigDecimal bd = BigDecimal.valueOf(input.getPrice()).setScale(2, RoundingMode.HALF_UP);
    double roundedPrice = bd.doubleValue();

    PriceRange range = classifier.classify(roundedPrice);

    return input.withTransformedFields(upperName, roundedPrice, range);
  }
}
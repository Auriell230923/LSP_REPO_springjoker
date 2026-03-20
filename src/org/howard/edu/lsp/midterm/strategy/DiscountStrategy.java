package org.howard.edu.lsp.midterm.strategy;

/**
 * This interface represents a discount strategy.
 * Each customer type has its own discount behavior.
 * 
 * @author Auriell
 */
public interface DiscountStrategy {

    /**
     * Calculates the final price after discount.
     * 
     * @param price the original price
     * @return the final price
     */
    double calculatePrice(double price);
}
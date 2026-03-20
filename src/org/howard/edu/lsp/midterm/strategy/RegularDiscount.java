package org.howard.edu.lsp.midterm.strategy;

/**
 * This class applies no discount for regular customers.
 * 
 * @author Auriell
 */
public class RegularDiscount implements DiscountStrategy {

    /**
     * Returns the original price.
     * 
     * @param price the original price
     * @return the same price
     */
    public double calculatePrice(double price) {
        return price;
    }
}
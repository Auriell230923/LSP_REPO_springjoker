package org.howard.edu.lsp.midterm.strategy;

/**
 * This class applies a 15% discount for holiday customers.
 * 
 * @author Auriell
 */
public class HolidayDiscount implements DiscountStrategy {

    /**
     * Applies a 15% discount.
     * 
     * @param price the original price
     * @return the discounted price
     */
    public double calculatePrice(double price) {
        return price * 0.85;
    }
}
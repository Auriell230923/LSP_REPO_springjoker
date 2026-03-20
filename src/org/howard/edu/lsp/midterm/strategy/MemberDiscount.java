package org.howard.edu.lsp.midterm.strategy;

/**
 * This class applies a 10% discount for member customers.
 * 
 * @author Auriell
 */
public class MemberDiscount implements DiscountStrategy {

    /**
     * Applies a 10% discount.
     * 
     * @param price the original price
     * @return the discounted price
     */
    public double calculatePrice(double price) {
        return price * 0.90;
    }
}
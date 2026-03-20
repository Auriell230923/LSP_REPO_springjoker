package org.howard.edu.lsp.midterm.strategy;

/**
 * This class applies a 20% discount for VIP customers.
 * 
 * @author Auriell
 */
public class VipDiscount implements DiscountStrategy {

    /**
     * Applies a 20% discount.
     * 
     * @param price the original price
     * @return the discounted price
     */
    public double calculatePrice(double price) {
        return price * 0.80;
    }
}
package org.howard.edu.lsp.midterm.strategy;

/**
 * This class uses a discount strategy to calculate prices.
 * 
 * @author Auriell
 */
public class PriceCalculator {
    private DiscountStrategy strategy;

    /**
     * Sets the discount strategy.
     * 
     * @param strategy the strategy to use
     */
    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Calculates the final price using the current strategy.
     * 
     * @param price the original price
     * @return the final price after discount
     */
    public double calculatePrice(double price) {
        return strategy.calculatePrice(price);
    }
}
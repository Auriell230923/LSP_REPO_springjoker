# Improved Design (CRC Cards)

## Order
- Responsibilities: Stores order information like items and total
- Collaborations: Works with TaxCalculator and DiscountService

## TaxCalculator
- Responsibilities: Calculates tax
- Collaborations: Uses Order

## DiscountService
- Responsibilities: Applies discounts
- Collaborations: Uses Order

## ReceiptPrinter
- Responsibilities: Prints the receipt
- Collaborations: Uses Order

## EmailService
- Responsibilities: Sends confirmation emails
- Collaborations: Uses Order

## Explanation

This design separates responsibilities into different classes. Each class has one main job, which makes the code easier to understand and maintain. The classes work together without depending too heavily on each other, which improves flexibility through out it.
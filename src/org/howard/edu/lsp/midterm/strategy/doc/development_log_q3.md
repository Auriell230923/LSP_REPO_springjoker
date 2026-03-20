# Development Log (Question 3)

For this question, I looked at the original PriceCalculator class and noticed that it relied on multiple if statements to handle different customer types. I recognized that this would be harder to maintain if more discount types were added later.

I then refactored the design using the Strategy Pattern. I created an interface for discount behavior and separate classes for regular, member, VIP, and holiday discounts. After that, I made a Driver class to test each strategy using the same purchase price.

## AI Usage
I used ChatGPT to keep me on track with how the Strategy Pattern should be organized and to make sure my classes matched the assignment requirements. 
 The conversation included asking for help with debugging, understanding some of the design process, and implementing the Strategy Pattern.
# Design Evaluation

The original PriceCalculator class has a design that is harder to maintain because it uses multiple if statements for each customer type. Every time a new type of discount is added, the class has to be changed, which makes the code less flexible.

This design also does not follow the open/closed principle very well because the class is not easy to extend without modifying existing code. A better design is to use the Strategy Pattern, where each discount is placed in its own class. This makes the code easier to organize, test, and extend.
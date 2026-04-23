Heuristic 1:

Name:
Keep data private.

Explanation:
This helps keep the code safe because other classes cannot directly change the data. Instead, the class controls how its data is accessed and modified. In class, we talked about how this prevents bugs and keeps things organized.

Heuristic 2:

Name:
Do not expose implementation details.

Explanation:
This improves readability because other classes only see what they need to use. For example, helper methods like getNextId() should not be public if they are only used inside the class. This keeps the design cleaner.

Heuristic 3:

Name:
Distribute responsibilities across classes.

Explanation:
This makes the code easier to maintain because each class has its own job. In lecture, we learned that one class should not do everything, and spreading responsibilities makes the system easier to understand and update.
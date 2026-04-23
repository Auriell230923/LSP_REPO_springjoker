Design Explanation:

The Template Method pattern is used in the Report class. The generateReport() method controls the steps: loadData, formatHeader, formatBody, and formatFooter.

StudentReport and CourseReport each override those steps with their own data and formatting. This lets both reports follow the same structure but still be different.

Polymorphism is shown by using a List of Report objects. Each report is treated the same, but runs its own version of the methods.
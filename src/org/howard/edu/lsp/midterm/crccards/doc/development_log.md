# Development Log

During the midterm, I created a simple task management system using Java. I started by creating the Task class, which stores the task ID, description, and status. I made sure that every task starts with a default status of "OPEN" and added methods to get the values and update the status.

Next, I created the TaskManager class. This class is responsible for managing all tasks. I used a LinkedHashMap to store the tasks so I could quickly find them by their ID while also keeping the order they were added. I added methods to add a task, find a task by ID, and get tasks by status. I also made sure to handle duplicate task IDs by throwing an exception.

After that, I finshed up, created the Driver class to test everything. In the Driver, I created multiple tasks, added them to the manager, updated their statuses, and tested different scenarios like duplicate IDs, invalid status updates, and searching for tasks.

One challenge I faced was making sure all the method names matched across the classes, especially with updating the task status. I also had to fix small syntax issues and understand how Java handles lists and maps.

I used ChatGPT to help me debug errors, understand why certain issues were happening, and guide me step-by-step through fixing them. Because I was not grasping how the errors were occuring. It helped me better understand how the classes should interact with each other and how to properly structure the program.
# Development Log

For this assignment, I created a simple task management system using Java. I started by creating the Task class, which stores the task ID, description, and status. I made sure that every task starts with a default status of "OPEN" and added methods to get the values and update the status.

Next, I created the TaskManager class. This class is responsible for managing all tasks. I used a LinkedHashMap to store the tasks so I could quickly find them by their ID while also keeping the order they were added. I added methods to add a task, find a task by ID, and get tasks by status. I also made sure to handle duplicate task IDs by throwing an exception.

After that, I created the Driver class to test everything. In the Driver, I created multiple tasks, added them to the manager, updated their statuses, and tested different scenarios like duplicate IDs, invalid status updates, and searching for tasks.

One challenge I faced was making sure all the method names matched across the classes, especially with updating the task status. I also had to fix small syntax issues and understand how Java handles lists and maps.

I used ChatGPT to help me debug errors, understand why certain issues were happening, and guide me step-by-step through fixing them. It helped me better understand how the classes should interact and how to properly structure the program.

Overall, during the midterm, it helped me understand how to organize code using multiple classes and how they work together in a program.
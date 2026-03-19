# CRC Cards

## Class: Task
- **Responsibilities:**
  - Stores task ID, description, and status
  - Provides methods to get task details
  - Updates task status with validation

- **Collaborations:**
  - None (Task does not depend on other classes)

---

## Class: TaskManager
- **Responsibilities:**
  - Stores and manages a collection of tasks
  - Adds new tasks and prevents duplicates
  - Finds tasks by ID
  - Filters tasks by status

- **Collaborations:**
  - Collaborates with Task class to manage task objects

---

## Explanation

TaskManager collaborates with Task because it stores and manages Task objects, meaning it depends on the Task class to function. However, Task does not collaborate with TaskManager because it only represents a single task and does not need to know anything about how tasks are stored or managed. This keeps the design simple and follows good object-oriented principles.
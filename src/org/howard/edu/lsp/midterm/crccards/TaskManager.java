package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * This class manages a collection of Task objects.
 * It lets us add tasks, find them by ID, and filter them by status.
 * 
 * @author Auriell
 */
public class TaskManager {
    // Using a map so we can quickly find tasks by ID
    private Map<String, Task> tasks;

    /**
     * Constructor for TaskManager.
     * Initializes the data structure to store tasks.
     */
    public TaskManager() {
        tasks = new LinkedHashMap<>(); // keeps insertion order
    }

    /**
     * Adds a task to the manager.
     * If a task with the same ID already exists, it throws an error.
     * 
     * @param task the task to add
     * @throws IllegalArgumentException if duplicate ID
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Duplicate task ID");
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Finds a task using its ID.
     * If it doesn't exist, returns null.
     * 
     * @param taskId the ID to search for
     * @return the task if found, otherwise null
     */
    public Task findTask(String taskId) {
        return tasks.get(taskId);
    }

    /**
     * Gets all tasks that match a certain status.
     * 
     * @param status the status to filter by
     * @return a list of matching tasks
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();

        // loop through all tasks and check their status
        for (Task t : tasks.values()) {
            if (t.getStatus().equals(status)) {
                result.add(t);
            }
        }

        return result;
    }
}

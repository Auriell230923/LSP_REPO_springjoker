package org.howard.edu.lsp.midterm.crccards;

/**
 * This class represents a single task.
 * It stores the task ID, description, and current status.
 * 
 * @author Auriell
 */
public class Task {
    private String taskId;
    private String description;
    private String status;

    /**
     * Constructor for creating a task.
     * By default, every task starts as OPEN.
     * 
     * @param taskId the ID of the task
     * @param description what the task is about
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN"; // default status
    }

    /**
     * Gets the task ID.
     * 
     * @return task ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Gets the task description.
     * 
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the current status of the task.
     * 
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Updates the task status.
     * Only allows OPEN, IN_PROGRESS, or COMPLETE.
     * If something else is passed in, it becomes UNKNOWN.
     * 
     * @param status the new status
     */
    public void setStatus(String status) {
        if (status.equals("OPEN") || status.equals("IN_PROGRESS") || status.equals("COMPLETE")) {
            this.status = status;
        } else {
            this.status = "UNKNOWN"; // invalid input
        }
    }

    /**
     * Converts the task into a readable string format.
     * Example: T1 Write report [OPEN]
     * 
     * @return formatted string
     */
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}
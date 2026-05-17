package ua.khpi.oop.lab11.model;

import java.util.Objects;

public class Task {
    private final String taskId;
    private final String description;
    private Developer assignee;

    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public Developer getAssignee() {
        return assignee;
    }

    public void setAssignee(Developer assignee) {
        this.assignee = assignee;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        return taskId.equals(task.taskId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId);
    }

    @Override
    public String toString() {
        String assigneeName = (assignee != null) ? assignee.getName() : "Не призначено";
        return String.format("Завдання %s: %s (Виконавець: %s)", taskId, description, assigneeName);
    }
}
package ua.khpi.oop.lab11.service;

import ua.khpi.oop.lab11.model.Developer;
import ua.khpi.oop.lab11.model.Task;

import java.util.*;

public class Sprint {
    private final Set<Developer> team = new HashSet<>();
    private final Queue<Task> backlog = new LinkedList<>();
    private final List<Task> activeTasks = new ArrayList<>();

    public void addDeveloper(Developer developer) {
        if (!team.add(developer)) {
            throw new IllegalArgumentException("Розробник вже є у команді: " + developer.getId());
        }
    }

    public void addTaskToBacklog(Task task) {
        backlog.offer(task);
    }

    public Task assignNextTask(Developer developer) {
        if (!team.contains(developer)) {
            throw new IllegalArgumentException("Розробника немає у поточній команді спринту");
        }

        Task nextTask = backlog.poll();
        if (nextTask != null) {
            nextTask.setAssignee(developer);
            activeTasks.add(nextTask);
        }
        return nextTask;
    }

    public boolean completeTask(String taskId) {
        Iterator<Task> iterator = activeTasks.iterator();
        while (iterator.hasNext()) {
            Task currentTask = iterator.next();
            if (currentTask.getTaskId().equals(taskId)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public Set<Developer> getTeam() {
        return Collections.unmodifiableSet(team);
    }

    public Queue<Task> getBacklog() {
        return new LinkedList<>(backlog);
    }

    public List<Task> getActiveTasks() {
        return Collections.unmodifiableList(activeTasks);
    }
}
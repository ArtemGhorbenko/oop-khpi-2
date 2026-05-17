package ua.khpi.oop.lab11.demo;

import ua.khpi.oop.lab11.model.Developer;
import ua.khpi.oop.lab11.model.Task;
import ua.khpi.oop.lab11.service.Sprint;

public class Main {
    public static void main(String[] args) {
        Sprint sprint = new Sprint();

        Developer dev1 = new Developer("D-01", "Артем");
        Developer dev2 = new Developer("D-02", "Марія");

        sprint.addDeveloper(dev1);
        sprint.addDeveloper(dev2);

        sprint.addTaskToBacklog(new Task("T-100", "Налаштувати базу даних"));
        sprint.addTaskToBacklog(new Task("T-101", "Розробити API авторизації"));
        sprint.addTaskToBacklog(new Task("T-102", "Написати модульні тести"));

        System.out.println("=== Команда спринту (Set) ===");
        for (Developer dev : sprint.getTeam()) {
            System.out.println(dev);
        }

        System.out.println("\n Черга завдань до розподілу (Queue) ");
        for (Task task : sprint.getBacklog()) {
            System.out.println(task);
        }

        System.out.println("\n Розподіл завдань ");
        sprint.assignNextTask(dev1);
        sprint.assignNextTask(dev2);

        System.out.println("\n Активні завдання (List) ");
        for (Task task : sprint.getActiveTasks()) {
            System.out.println(task);
        }

        System.out.println("\n Завершення завдання T-100 ");
        boolean isCompleted = sprint.completeTask("T-100");
        System.out.println("Статус завершення: " + (isCompleted ? "Успішно" : "Помилка"));

        System.out.println("\n Залишок активних завдань ");
        for (Task task : sprint.getActiveTasks()) {
            System.out.println(task);
        }
    }
}
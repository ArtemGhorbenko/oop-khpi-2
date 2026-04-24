package ua.khpi.oop.lab06.model;

public abstract class Assessment {
    protected final String title;
    protected final int maxScore;
    protected boolean completed;

    protected Assessment(String title, int maxScore, boolean completed) {
        this.title = title;
        this.maxScore = maxScore;
        this.completed = completed;
    }

    public String summary() {
        return "Предмет: " + title + " (Макс. бал: " + maxScore + "), Статус: " + (completed ? "Завершено" : "В процесі");
    }

    public void markAsCompleted() {
        this.completed = true;
    }

    public abstract String evaluate(int pointsScored);
}

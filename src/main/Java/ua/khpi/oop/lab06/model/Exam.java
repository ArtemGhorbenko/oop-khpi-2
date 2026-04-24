package ua.khpi.oop.lab06.model;

public class Exam extends Assessment {
    private final String examinerName;

    public Exam(String title, int maxScore, boolean completed, String examinerName) {
        super(title, maxScore, completed);
        this.examinerName = examinerName;
    }

    @Override
    public String evaluate(int pointsScored) {
        if (!completed) {
            return "Іспит ще не завершено.";
        }
        boolean passed = pointsScored >= (maxScore * 0.6);
        return passed ? "Іспит складено успішно! Екзаменатор: " + examinerName
                : "Іспит не складено. Зверніться до " + examinerName + " для перескладання.";
    }
}
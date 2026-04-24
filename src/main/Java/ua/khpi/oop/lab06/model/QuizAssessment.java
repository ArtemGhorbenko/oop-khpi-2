package ua.khpi.oop.lab06.model;

public class QuizAssessment extends Assessment {
    private final int numberOfQuestions;

    public QuizAssessment(String title, int maxScore, boolean completed, int numberOfQuestions) {
        super(title, maxScore, completed);
        this.numberOfQuestions = numberOfQuestions;
    }

    @Override
    public String evaluate(int pointsScored) {
        if (!completed) {
            return "Тест ще відкритий для проходження.";
        }
        double percentage = ((double) pointsScored / maxScore) * 100;
        return String.format("Тест завершено. Ваш результат: %.1f%%. Кількість питань: %d.", percentage, numberOfQuestions);
    }
}
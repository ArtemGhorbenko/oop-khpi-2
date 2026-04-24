package ua.khpi.oop.lab06.model;

public class CourseProject extends Assessment {
    private final boolean requiresPresentation;

    public CourseProject(String title, int maxScore, boolean completed, boolean requiresPresentation) {
        super(title, maxScore, completed);
        this.requiresPresentation = requiresPresentation;
    }

    @Override
    public String evaluate(int pointsScored) {
        if (!completed) {
            return "Проєкт ще в стадії розробки.";
        }
        String presentationInfo = requiresPresentation ? "Очікується публічний захист." : "Оцінка виставляється за код.";
        return "Проєкт здано. Оцінка: " + pointsScored + "/" + maxScore + ". " + presentationInfo;
    }
}
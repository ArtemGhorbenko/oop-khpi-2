package ua.khpi.oop.lab06.demo;

import ua.khpi.oop.lab06.model.*;

public class Main {
    public static void main(String[] args) {
        Assessment[] assessments = {
                new Exam("Вища математика", 100, true, "О.І. Петренко"),
                new QuizAssessment("Історія України", 20, true, 40),
                new CourseProject("ООП (Java)", 100, true, true),
                new CourseProject("Бази даних", 100, false, false) // Не завершено
        };

        System.out.println("--- Результати оцінювання ---");

        for (Assessment assessment : assessments) {
            System.out.println(assessment.summary());
            System.out.println("Результат: " + assessment.evaluate(85));
            System.out.println("-----------------------------");
        }
    }
}
package ua.khpi.oop.lab06.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AssessmentPolymorphismTest {

    @Test
    void shouldDispatchToConcreteImplementations() {
        Assessment[] assessments = {
                new Exam("Math", 100, true, "Prof. X"),
                new QuizAssessment("History", 10, true, 20),
                new CourseProject("Java", 100, true, false)
        };

        String[] actual = new String[assessments.length];

        // Імітуємо, що за всі завдання отримано 10 балів
        for (int i = 0; i < assessments.length; i++) {
            actual[i] = assessments[i].evaluate(10);
        }

        assertEquals("Іспит не складено. Зверніться до Prof. X для перескладання.", actual[0]);
        assertEquals("Тест завершено. Ваш результат: 100,0%. Кількість питань: 20.", actual[1]);
        assertEquals("Проєкт здано. Оцінка: 10/100. Оцінка виставляється за код.", actual[2]);
    }
}
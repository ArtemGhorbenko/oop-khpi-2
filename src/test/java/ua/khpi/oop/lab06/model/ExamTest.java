package ua.khpi.oop.lab06.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ExamTest {

    @Test
    void shouldIncludeBaseStateInSummary() {
        Exam exam = new Exam("Physics", 100, false, "Einstein");
        assertTrue(exam.summary().contains("Physics"));
        assertTrue(exam.summary().contains("В процесі"));
    }

    @Test
    void shouldNotEvaluateIfNotCompleted() {
        Exam exam = new Exam("Physics", 100, false, "Einstein");
        assertEquals("Іспит ще не завершено.", exam.evaluate(90));
    }
}
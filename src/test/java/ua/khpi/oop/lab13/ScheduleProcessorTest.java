package ua.khpi.oop.lab13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab13.model.ClassRecord;
import ua.khpi.oop.lab13.service.ScheduleProcessor;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleProcessorTest {
    private ScheduleProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new ScheduleProcessor();
    }

    @Test
    void shouldNormalizeWhitespace() {
        String raw = "  Понеділок  ;   1 ;  08:30 ";
        String expected = "Понеділок ; 1 ; 08:30";
        assertEquals(expected, processor.normalizeWhitespace(raw));
    }

    @Test
    void shouldParseValidLine() {
        String line = "Середа ; 3 ; 12:10 ; 401-У2 ; Сидоренко А.А.";
        ClassRecord record = processor.parseLine(line);

        assertEquals("Середа", record.getDayOfWeek());
        assertEquals(3, record.getClassNumber());
        assertEquals("12:10", record.getTime());
        assertEquals("401-У2", record.getRoom());
        assertEquals("Сидоренко А.А.", record.getTeacher());
    }

    @Test
    void shouldRejectInvalidRoomFormat() {
        String invalidLine = "Четвер ; 1 ; 08:30 ; Ауд-204 ; Іванов І.І.";

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> processor.parseLine(invalidLine)
        );
        assertTrue(exception.getMessage().contains("Некоректний формат"));
    }
}
package ua.khpi.oop.lab08.persistence;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import ua.khpi.oop.lab08.exception.InvalidCampusDataException;
import ua.khpi.oop.lab08.model.ExamReminder;
import ua.khpi.oop.lab08.service.CampusServiceRegistry;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class CampusFileManagerTest {

    @TempDir
    Path tempDir;

    @Test
    void shouldSaveAndLoadTextFormat() throws Exception {
        CampusServiceRegistry registry = new CampusServiceRegistry();
        registry.addService(new ExamReminder("Вища математика", "2026-05-10"));

        CampusFileManager manager = new CampusFileManager();
        Path file = tempDir.resolve("test_campus.txt");

        manager.saveAsText(registry, file);
        CampusServiceRegistry loaded = manager.loadFromText(file);

        assertEquals(1, loaded.getServices().size());
        assertTrue(loaded.getServices().get(0).getInfo().contains("Вища математика"));
    }

    @Test
    void shouldThrowExceptionForEmptySubject() {
        assertThrows(InvalidCampusDataException.class, () -> {
            new ExamReminder("", "2026-02-05");
        });
    }
}
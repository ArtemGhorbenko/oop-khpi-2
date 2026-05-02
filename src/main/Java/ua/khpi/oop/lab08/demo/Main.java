package ua.khpi.oop.lab08.demo;

import ua.khpi.oop.lab08.exception.InvalidCampusDataException;
import ua.khpi.oop.lab08.model.*;
import ua.khpi.oop.lab08.persistence.CampusFileManager;
import ua.khpi.oop.lab08.service.CampusServiceRegistry;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        CampusServiceRegistry registry = new CampusServiceRegistry();
        CampusFileManager fileManager = new CampusFileManager();

        Path textPath = Path.of("build", "lab08", "campus.txt");
        Path binaryPath = Path.of("build", "lab08", "campus.bin");

        try {
            registry.addService(new ExamReminder("ООП", "2026-06-15"));
            registry.addService(new RoomBooking("204-У1", "10:25"));
            registry.addService(new ConsultationSlot("А.О. Горбенко", "14:00"));

            fileManager.saveAsText(registry, textPath);
            CampusServiceRegistry restoredFromText = fileManager.loadFromText(textPath);
            System.out.println("--- Відновлено з текстового файлу ---");
            restoredFromText.getServices().forEach(s -> System.out.println(s.getInfo()));

            fileManager.serialize(restoredFromText, binaryPath);
            CampusServiceRegistry restoredFromBinary = fileManager.deserialize(binaryPath);
            System.out.println("\n--- Відновлено з бінарного файлу ---");
            restoredFromBinary.getServices().forEach(s -> System.out.println(s.getInfo()));

            System.out.println("\n--- Перевірка помилки ---");
            new ExamReminder("", "2026-01-01");

        } catch (InvalidCampusDataException e) {
            System.err.println("Помилка даних: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Помилка файлів: " + e.getMessage());
        }
    }
}
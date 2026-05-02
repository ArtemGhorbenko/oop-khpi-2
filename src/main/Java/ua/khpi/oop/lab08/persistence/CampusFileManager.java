package ua.khpi.oop.lab08.persistence;

import ua.khpi.oop.lab08.exception.InvalidCampusDataException;
import ua.khpi.oop.lab08.model.*;
import ua.khpi.oop.lab08.service.CampusServiceRegistry;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class CampusFileManager {

    public void saveAsText(CampusServiceRegistry registry, Path path) throws IOException {
        ensureParentDirectory(path);
        List<String> lines = registry.getServices().stream()
                .map(CampusService::toTextLine)
                .toList();
        Files.write(path, lines, StandardCharsets.UTF_8);
    }

    public CampusServiceRegistry loadFromText(Path path) throws IOException, InvalidCampusDataException {
        CampusServiceRegistry registry = new CampusServiceRegistry();
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        int lineNumber = 1;

        for (String line : lines) {
            if (line.isBlank()) continue;
            String[] parts = line.split(";", -1);
            if (parts.length != 3) {
                throw new InvalidCampusDataException("Неправильна кількість полів у рядку " + lineNumber);
            }
            try {
                switch (parts[0]) {
                    case "EXAM" -> registry.addService(new ExamReminder(parts[1], parts[2]));
                    case "ROOM" -> registry.addService(new RoomBooking(parts[1], parts[2]));
                    case "CONSULTATION" -> registry.addService(new ConsultationSlot(parts[1], parts[2]));
                    default -> throw new InvalidCampusDataException("Невідомий тип сервісу: " + parts[0]);
                }
            } catch (Exception ex) {
                throw new InvalidCampusDataException("Помилка даних у рядку " + lineNumber, ex);
            }
            lineNumber++;
        }
        return registry;
    }

    public void serialize(CampusServiceRegistry registry, Path path) throws IOException {
        ensureParentDirectory(path);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(path))) {
            outputStream.writeObject(registry);
        }
    }

    public CampusServiceRegistry deserialize(Path path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(path))) {
            return (CampusServiceRegistry) inputStream.readObject();
        }
    }

    private void ensureParentDirectory(Path path) throws IOException {
        Path parent = path.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }
    }
}
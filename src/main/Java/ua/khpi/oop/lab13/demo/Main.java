package ua.khpi.oop.lab13.demo;

import ua.khpi.oop.lab13.model.ClassRecord;
import ua.khpi.oop.lab13.service.ScheduleProcessor;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> rawLines = readResourceLines("schedule.txt");

            ScheduleProcessor processor = new ScheduleProcessor();
            List<String> errorLog = new ArrayList<>();

            List<ClassRecord> validRecords = processor.parseLines(rawLines, errorLog);

            String finalReport = processor.buildReport(validRecords, errorLog);
            System.out.println(finalReport);

        } catch (Exception e) {
            System.err.println("Помилка роботи програми: " + e.getMessage());
        }
    }

    private static List<String> readResourceLines(String resourceName) throws IOException, URISyntaxException {
        URL resource = Main.class.getClassLoader().getResource(resourceName);
        if (resource == null) {
            throw new IOException("Файл не знайдено: " + resourceName);
        }
        return Files.readAllLines(Path.of(resource.toURI()));
    }
}
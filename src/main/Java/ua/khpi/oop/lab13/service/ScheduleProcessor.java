package ua.khpi.oop.lab13.service;

import ua.khpi.oop.lab13.model.ClassRecord;
import ua.khpi.oop.lab13.model.ScheduleReport;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScheduleProcessor {

    private static final Pattern SCHEDULE_PATTERN = Pattern.compile(
            "^([А-Яа-яІіЇїЄє']+)\\s*;\\s*(\\d)\\s*;\\s*(\\d{2}:\\d{2})\\s*;\\s*(\\d{1,3}-[А-Яа-яІіЇїЄє0-9]+)\\s*;\\s*([А-Яа-яІіЇїЄє\\s\\.]+)$"
    );

    public String normalizeWhitespace(String line) {
        if (line == null) return "";
        return line.trim().replaceAll("\\s+", " ");
    }

    public ClassRecord parseLine(String rawLine) {
        String normalized = normalizeWhitespace(rawLine);
        Matcher matcher = SCHEDULE_PATTERN.matcher(normalized);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Некоректний формат рядка або помилка формату аудиторії: " + rawLine);
        }

        String day = matcher.group(1);
        int number = Integer.parseInt(matcher.group(2));
        String time = matcher.group(3);
        String room = matcher.group(4);
        String teacher = matcher.group(5);

        return new ClassRecord(day, number, time, room, teacher);
    }

    public List<ClassRecord> parseLines(List<String> rawLines, List<String> errorLog) {
        List<ClassRecord> records = new ArrayList<>();
        for (String line : rawLines) {
            if (normalizeWhitespace(line).isBlank()) continue;

            try {
                records.add(parseLine(line));
            } catch (IllegalArgumentException e) {
                errorLog.add(e.getMessage());
            }
        }
        return records;
    }

    public String buildReport(List<ClassRecord> records, List<String> errorLog) {
        ScheduleReport summary = new ScheduleReport(records.size(), errorLog.size());
        StringBuilder report = new StringBuilder();

        report.append(" Звіт про розклад занять \n");
        report.append("Успішно оброблено записів: ").append(summary.getTotalValidRecords()).append("\n");
        report.append("Виявлено помилок: ").append(summary.getTotalErrors()).append("\n\n");

        report.append("--- Валідний розклад ---\n");
        for (ClassRecord record : records) {
            report.append(record.toString()).append("\n");
        }

        if (!errorLog.isEmpty()) {
            report.append("\n--- Журнал помилок ---\n");
            for (String error : errorLog) {
                report.append("[Помилка] ").append(error).append("\n");
            }
        }

        return report.toString();
    }
}
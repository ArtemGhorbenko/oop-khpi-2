package ua.khpi.oop.lab13.model;

import java.util.Objects;

public class ClassRecord {
    private final String dayOfWeek;
    private final int classNumber;
    private final String time;
    private final String room;
    private final String teacher;

    public ClassRecord(String dayOfWeek, int classNumber, String time, String room, String teacher) {
        this.dayOfWeek = Objects.requireNonNull(dayOfWeek, "День не може бути null");
        this.classNumber = classNumber;
        this.time = Objects.requireNonNull(time, "Час не може бути null");
        this.room = Objects.requireNonNull(room, "Аудиторія не може бути null");
        this.teacher = Objects.requireNonNull(teacher, "Викладач не може бути null");
    }

    public String getDayOfWeek() { return dayOfWeek; }
    public int getClassNumber() { return classNumber; }
    public String getTime() { return time; }
    public String getRoom() { return room; }
    public String getTeacher() { return teacher; }

    @Override
    public String toString() {
        return String.format("%s | Пара %d (%s) | Ауд: %s | Викладач: %s",
                dayOfWeek, classNumber, time, room, teacher);
    }
}
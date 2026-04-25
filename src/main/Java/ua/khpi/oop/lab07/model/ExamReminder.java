package ua.khpi.oop.lab07.model;

import ua.khpi.oop.lab07.contracts.Notifiable;

public class ExamReminder implements Notifiable {
    private final String subject;

    public ExamReminder(String subject) {
        this.subject = subject;
    }

    @Override
    public String sendNotification(String user) {
        return "Нагадування для " + user + ": Завтра іспит з предмету '" + subject + "'.";
    }
}
package ua.khpi.oop.lab08.model;
import ua.khpi.oop.lab08.exception.InvalidCampusDataException;

public class ExamReminder implements CampusService {
    private final String subject;
    private final String date;

    public ExamReminder(String subject, String date) throws InvalidCampusDataException {
        if (subject == null || subject.isBlank()) throw new InvalidCampusDataException("Назва предмету не може бути порожньою");
        this.subject = subject;
        this.date = date;
    }

    @Override
    public String toTextLine() { return "EXAM;" + subject + ";" + date; }

    @Override
    public String getInfo() { return "Іспит: " + subject + " (" + date + ")"; }
}
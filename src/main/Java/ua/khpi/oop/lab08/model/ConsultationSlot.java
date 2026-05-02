package ua.khpi.oop.lab08.model;
import ua.khpi.oop.lab08.exception.InvalidCampusDataException;

public class ConsultationSlot implements CampusService {
    private final String professorName;
    private final String time;

    public ConsultationSlot(String professorName, String time) throws InvalidCampusDataException {
        if (professorName == null || professorName.isBlank()) throw new InvalidCampusDataException("Ім'я викладача обов'язкове");
        this.professorName = professorName;
        this.time = time;
    }

    @Override
    public String toTextLine() { return "CONSULTATION;" + professorName + ";" + time; }

    @Override
    public String getInfo() { return "Консультація: " + professorName + " о " + time; }
}
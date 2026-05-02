package ua.khpi.oop.lab08.model;
import ua.khpi.oop.lab08.exception.InvalidCampusDataException;

public class RoomBooking implements CampusService {
    private final String roomNumber;
    private final String time;

    public RoomBooking(String roomNumber, String time) throws InvalidCampusDataException {
        if (roomNumber == null || roomNumber.isBlank()) throw new InvalidCampusDataException("Номер аудиторії обов'язковий");
        this.roomNumber = roomNumber;
        this.time = time;
    }

    @Override
    public String toTextLine() { return "ROOM;" + roomNumber + ";" + time; }

    @Override
    public String getInfo() { return "Бронювання: ауд. " + roomNumber + " на " + time; }
}
package ua.khpi.oop.lab07.model;

import ua.khpi.oop.lab07.contracts.Schedulable;

public class RoomBooking implements Schedulable {
    private final String roomNumber;

    public RoomBooking(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String schedule(String time) {
        return "Аудиторія " + roomNumber + " успішно заброньована на " + time + ".";
    }
}
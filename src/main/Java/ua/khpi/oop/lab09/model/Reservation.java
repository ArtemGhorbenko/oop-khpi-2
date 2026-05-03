package ua.khpi.oop.lab09.model;

public class Reservation {
    private final String reservationId;
    private final String date;

    public Reservation(String reservationId, String date) {
        this.reservationId = reservationId;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Бронь{" + "id='" + reservationId + "', дата='" + date + "'}";
    }
}
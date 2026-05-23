package ua.khpi.oop.lab15.model;

public class BookingRequest {
    private final String guestName;
    private final int seatsToBook;

    public BookingRequest(String guestName, int seatsToBook) {
        this.guestName = guestName;
        this.seatsToBook = seatsToBook;
    }

    public int getSeatsToBook() { return seatsToBook; }
}
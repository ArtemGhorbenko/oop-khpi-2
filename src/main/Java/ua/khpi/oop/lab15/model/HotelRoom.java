package ua.khpi.oop.lab15.model;

public class HotelRoom {
    private final String roomId;
    private final int capacity;
    private int bookedSeats;

    public HotelRoom(String roomId, int capacity) {
        this.roomId = roomId;
        this.capacity = capacity;
        this.bookedSeats = 0;
    }

    public String getRoomId() { return roomId; }
    public int getCapacity() { return capacity; }
    public int getBookedSeats() { return bookedSeats; }
    public int getAvailableSeats() { return capacity - bookedSeats; }

    public boolean bookUnsafe(int amount) {
        if (bookedSeats + amount <= capacity) {
            int current = bookedSeats; // Читання
            bookedSeats = current + amount; // Запис (втрата оновлень)
            return true;
        }
        return false;
    }

    public synchronized boolean bookSafe(int amount) {
        if (bookedSeats + amount <= capacity) {
            bookedSeats += amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Кімната %s: заброньовано %d з %d", roomId, bookedSeats, capacity);
    }
}
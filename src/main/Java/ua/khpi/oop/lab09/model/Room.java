package ua.khpi.oop.lab09.model;

public class Room implements Comparable<Room> {
    private final String roomNumber;
    private final int capacity;

    public Room(String roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    @Override
    public int compareTo(Room other) {
        return Integer.compare(this.capacity, other.capacity);
    }

    @Override
    public String toString() {
        return "Кімната{" + "номер='" + roomNumber + "', місць=" + capacity + "}";
    }
}
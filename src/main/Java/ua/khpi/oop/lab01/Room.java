package ua.khpi.oop.lab01;

import java.util.Objects;

public class Room {
    private final String roomNumber;
    private boolean available;

    public Room(String roomNumber, boolean available) {
        this.roomNumber = roomNumber;
        this.available = available;
    }

    public Room(String roomNumber) {
        this(roomNumber, true);
    }

    public void bookBy(Guest guest) {
        if (guest != null && guest.isVerified() && available) {
            available = false;
        }
    }

    public void releaseRoom() {
        this.available = true;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", available=" + available +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Room)) return false;
        Room room = (Room) obj;
        return Objects.equals(roomNumber, room.roomNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber);
    }
}
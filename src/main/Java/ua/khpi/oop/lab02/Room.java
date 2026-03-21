package ua.khpi.oop.lab02;

import java.util.Objects;

public class Room {
    private final String roomNumber;
    private boolean available;
    private Guest currentGuest;

    public Room(String roomNumber, boolean available) {
        this.roomNumber = roomNumber;
        this.available = available;
        this.currentGuest = null;
    }

    public Room(String roomNumber) {
        this(roomNumber, true);
    }

    public void bookBy(Guest guest) {
        if (guest != null && guest.isVerified() && available) {
            this.available = false;
            this.currentGuest = guest;
        }
    }

    public void releaseRoom() {
        this.available = true;
        this.currentGuest = null;
    }

    public Guest getCurrentGuest() {
        return currentGuest;
    }

    @Override
    public String toString() {
        String guestInfo = (currentGuest != null) ? currentGuest.toString() : "ніхто";

        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", available=" + available +
                ", currentGuest=" + guestInfo +
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
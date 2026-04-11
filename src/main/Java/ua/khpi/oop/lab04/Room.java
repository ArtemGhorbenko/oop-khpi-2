package ua.khpi.oop.lab04;
import java.util.Objects;

public class Room {
    private final String roomNumber;
    private boolean available;
    private Guest currentGuest;

    public Room(String roomNumber, boolean available) {
        if (roomNumber == null || roomNumber.isBlank()) {
            throw new IllegalArgumentException("Номер кімнати не може бути порожнім");
        }
        this.roomNumber = roomNumber;
        this.available = available;
        this.currentGuest = null;
    }

    public Room(String roomNumber) { this(roomNumber, true); }

    public void bookBy(Guest guest) {
        if (guest == null) throw new IllegalArgumentException("Гість не може бути null");
        if (!available) throw new IllegalStateException("Кімната вже зайнята");
        if (guest.isVerified()) {
            this.available = false;
            this.currentGuest = guest;
        }
    }

    public void releaseRoom() {
        this.available = true;
        this.currentGuest = null;
    }

    public String getRoomNumber() { return roomNumber; }
    public boolean isAvailable() { return available; }
    public Guest getCurrentGuest() { return currentGuest; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Room)) return false;
        Room room = (Room) obj;
        return Objects.equals(roomNumber, room.roomNumber);
    }

    @Override
    public int hashCode() { return Objects.hash(roomNumber); }
}
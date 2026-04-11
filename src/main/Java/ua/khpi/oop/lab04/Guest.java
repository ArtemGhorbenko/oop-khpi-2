package ua.khpi.oop.lab04;

public class Guest {
    private final String guestId;
    private final String fullName;

    public Guest(String guestId, String fullName) {
        if (guestId == null || guestId.isBlank()) throw new IllegalArgumentException("ID не може бути порожнім");
        if (fullName == null || fullName.isBlank()) throw new IllegalArgumentException("Ім'я не може бути порожнім");
        this.guestId = guestId;
        this.fullName = fullName;
    }

    public boolean isVerified() { return true; }

    public String getGuestId() { return guestId; }
    public String getFullName() { return fullName; }

    @Override
    public String toString() {
        return "Guest{guestId='" + guestId + "', fullName='" + fullName + "'}";
    }
}
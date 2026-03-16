package ua.khpi.oop.lab01;

public class Guest {
    private final String guestId;
    private final String fullName;

    public Guest(String guestId, String fullName) {
        this.guestId = guestId;
        this.fullName = fullName;
    }

    public boolean isVerified() {
        return true;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "guestId='" + guestId + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
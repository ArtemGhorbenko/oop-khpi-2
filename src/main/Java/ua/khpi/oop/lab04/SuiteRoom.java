package ua.khpi.oop.lab04;

public class SuiteRoom extends Room {
    private final boolean hasBalcony;

    public SuiteRoom(String roomNumber, boolean available, boolean hasBalcony) {
        super(roomNumber, available);
        this.hasBalcony = hasBalcony;
    }

    @Override
    public String toString() {
        return "SuiteRoom{" +
                "hasBalcony=" + hasBalcony +
                "} " + super.toString();
    }
}
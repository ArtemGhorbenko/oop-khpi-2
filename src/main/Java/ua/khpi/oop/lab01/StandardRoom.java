package ua.khpi.oop.lab01;

public class StandardRoom extends Room {
    private final int bedsCount;

    public StandardRoom(String roomNumber, boolean available, int bedsCount) {
        super(roomNumber, available);
        this.bedsCount = bedsCount;
    }

    @Override
    public String toString() {
        return "StandardRoom{" +
                "bedsCount=" + bedsCount +
                "} " + super.toString();
    }
}
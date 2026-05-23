package ua.khpi.oop.lab15.threads;

import ua.khpi.oop.lab15.model.HotelRoom;

public class BookingTask implements Runnable {
    private final HotelRoom room;
    private final int iterations;
    private final boolean useSafeMethod;

    public BookingTask(HotelRoom room, int iterations, boolean useSafeMethod) {
        this.room = room;
        this.iterations = iterations;
        this.useSafeMethod = useSafeMethod;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterations; i++) {
            if (useSafeMethod) {
                room.bookSafe(1);
            } else {
                room.bookUnsafe(1);
            }
        }
    }
}
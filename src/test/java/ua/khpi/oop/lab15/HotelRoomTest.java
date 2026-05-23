package ua.khpi.oop.lab15;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab15.model.HotelRoom;

import static org.junit.jupiter.api.Assertions.*;

class HotelRoomTest {

    @Test
    void shouldBookSeatsSuccessfullyWhenCapacityAllows() {
        HotelRoom room = new HotelRoom("101", 10);

        boolean result = room.bookSafe(3);

        assertTrue(result);
        assertEquals(3, room.getBookedSeats());
        assertEquals(7, room.getAvailableSeats());
    }

    @Test
    void shouldRejectBookingWhenExceedingCapacity() {
        HotelRoom room = new HotelRoom("102", 5);

        room.bookSafe(4);
        boolean overbookResult = room.bookSafe(2);

        assertFalse(overbookResult);
        assertEquals(4, room.getBookedSeats());
    }

    @Test
    void unsafeMethodAndSafeMethodHaveSameBaseLogic() {
        HotelRoom room1 = new HotelRoom("1", 5);
        HotelRoom room2 = new HotelRoom("2", 5);

        room1.bookUnsafe(2);
        room2.bookSafe(2);

        assertEquals(room1.getBookedSeats(), room2.getBookedSeats());
    }
}
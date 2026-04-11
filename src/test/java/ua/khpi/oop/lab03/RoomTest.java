package ua.khpi.oop.lab03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    private Room room;
    private Guest guest;

    @BeforeEach
    void setup() {
        room = new Room("101");
        guest = new Guest("G-01", "Іван Іваненко");
    }

    @Test
    @DisplayName("Конструктор має правильно ініціалізувати початковий стан")
    void constructorShouldStoreInitialState() {
        assertEquals("101", room.getRoomNumber());
        assertTrue(room.isAvailable());
        assertNull(room.getCurrentGuest());
    }

    @Test
    @DisplayName("Метод bookBy має робити кімнату зайнятою та зберігати гостя")
    void bookByShouldChangeAvailabilityAndSetGuest() {
        room.bookBy(guest);

        assertFalse(room.isAvailable());
        assertEquals(guest, room.getCurrentGuest());
    }

    @Test
    @DisplayName("Метод releaseRoom має звільняти кімнату та видаляти гостя")
    void releaseRoomShouldClearState() {
        room.bookBy(guest);
        room.releaseRoom();

        assertTrue(room.isAvailable());
        assertNull(room.getCurrentGuest());
    }

    @Test
    @DisplayName("Бронювання порожнім гостем (null) має викидати IllegalArgumentException")
    void bookingWithNullGuestThrowsException() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> room.bookBy(null)
        );
        assertTrue(ex.getMessage().contains("null"));
    }

    @Test
    @DisplayName("Бронювання вже зайнятої кімнати має викидати IllegalStateException")
    void bookingAlreadyBookedRoomThrowsException() {
        room.bookBy(guest);
        Guest anotherGuest = new Guest("G-02", "Петро Петренко");

        assertThrows(
                IllegalStateException.class,
                () -> room.bookBy(anotherGuest)
        );
    }
}
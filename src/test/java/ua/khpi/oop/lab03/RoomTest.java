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
    @DisplayName("Конструктор должен правильно задавать начальное состояние")
    void constructorShouldStoreInitialState() {
        assertEquals("101", room.getRoomNumber());
        assertTrue(room.isAvailable());
        assertNull(room.getCurrentGuest());
    }

    @Test
    @DisplayName("Метод bookBy должен делать комнату занятой и сохранять гостя")
    void bookByShouldChangeAvailabilityAndSetGuest() {
        room.bookBy(guest); // Выполняем бронирование

        assertFalse(room.isAvailable());
        assertEquals(guest, room.getCurrentGuest());
    }

    @Test
    @DisplayName("Метод releaseRoom должен освобождать комнату и удалять гостя")
    void releaseRoomShouldClearState() {
        room.bookBy(guest);
        room.releaseRoom();

        assertTrue(room.isAvailable());
        assertNull(room.getCurrentGuest());
    }

    @Test
    @DisplayName("Бронирование с гостем null должно выбрасывать IllegalArgumentException")
    void bookingWithNullGuestThrowsException() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> room.bookBy(null)
        );
        assertTrue(ex.getMessage().contains("null"));
    }

    @Test
    @DisplayName("Бронирование уже занятой комнаты должно выбрасывать IllegalStateException")
    void bookingAlreadyBookedRoomThrowsException() {
        room.bookBy(guest);
        Guest anotherGuest = new Guest("G-02", "Петро Петренко");

        assertThrows(
                IllegalStateException.class,
                () -> room.bookBy(anotherGuest)
        );
    }
}
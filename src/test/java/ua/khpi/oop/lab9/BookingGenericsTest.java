package ua.khpi.oop.lab09;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab09.model.*;
import ua.khpi.oop.lab09.util.BookingUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingGenericsTest {

    @Test
    void testGenericClassInstantiation() {
        Customer c = new Customer("1", "Test");
        Room r = new Room("101", 2);

        BookingRecord<Customer, Room> record = new BookingRecord<>(c, r, "OK");

        assertEquals(c, record.getClient());
        assertEquals(r, record.getResource());
    }

    @Test
    void testGenericMethodFindsMaximum() {
        Room r1 = new Room("1", 1);
        Room r2 = new Room("2", 5);
        Room r3 = new Room("3", 2);

        List<Room> rooms = List.of(r1, r2, r3);
        Room maxRoom = BookingUtils.findMaximum(rooms);

        assertEquals(r2, maxRoom);
    }
}
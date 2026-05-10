package ua.khpi.oop.lab10;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab10.container.BookingContainer;
import static org.junit.jupiter.api.Assertions.*;

class BookingContainerTest {

    @Test
    void testContainerIteration() {
        BookingContainer<Integer> container = new BookingContainer<>();
        container.add(10);
        container.add(20);

        int elementsCount = 0;
        for (Integer item : container) {
            elementsCount++;
        }

        assertEquals(2, elementsCount);
    }
}
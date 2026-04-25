package ua.khpi.oop.lab07.model;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab07.contracts.Schedulable;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SchedulableContractTest {
    @Test
    void shouldSupportDifferentSchedulableImplementations() {
        Schedulable[] schedulables = {
                new RoomBooking("101"),
                new ConsultationSlot("Dr. Smith")
        };

        for (Schedulable item : schedulables) {
            assertFalse(item.schedule("12:00").isBlank());
        }
    }
}
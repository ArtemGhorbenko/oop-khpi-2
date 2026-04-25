package ua.khpi.oop.lab07.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConsultationSlotTest {
    @Test
    void testMultipleInterfacesLogic() {
        ConsultationSlot slot = new ConsultationSlot("Prof. X");

        assertTrue(slot.sendNotification("Artem").contains("ще не визначено"));

        assertTrue(slot.schedule("10:00").contains("призначена на 10:00"));

        assertTrue(slot.sendNotification("Artem").contains("підтверджена"));
    }
}
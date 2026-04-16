package ua.khpi.oop.lab05;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab05.model.CardiacSurgeon;
import ua.khpi.oop.lab05.model.MedicalWorker;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HierarchyTest {

    @Test
    void testCardiacSurgeonInheritsAndMaintainsState() {
        CardiacSurgeon surgeon = new CardiacSurgeon("Хаус", 20, "LIC-1", 300, "Expert");

        assertEquals("Хаус", surgeon.getName());
        assertEquals(20, surgeon.getExperienceYears());
        assertEquals("LIC-1", surgeon.getLicenseNumber());
        assertEquals(300, surgeon.getSuccessfulSurgeries());
        assertEquals("Expert", surgeon.getCertificationLevel());
    }

    @Test
    void testDescriptionOverridesCorrectly() {
        MedicalWorker worker = new MedicalWorker("Асистент", 2);
        assertEquals("Працівник: Асистент, досвід: 2 р.", worker.description());

        CardiacSurgeon surgeon = new CardiacSurgeon("Хаус", 20, "L-1", 300, "Pro");
        String expectedDesc = "Працівник: Хаус, досвід: 20 р., ліцензія: L-1, успішних операцій: 300, сертифікація: Pro";
        assertEquals(expectedDesc, surgeon.description());
    }
}

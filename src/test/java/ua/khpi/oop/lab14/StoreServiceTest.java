package ua.khpi.oop.lab14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab14.model.Invoice;
import ua.khpi.oop.lab14.model.Order;
import ua.khpi.oop.lab14.model.Product;
import ua.khpi.oop.lab14.service.StoreService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StoreServiceTest {
    private StoreService storeService;

    @BeforeEach
    void setUp() {
        storeService = new StoreService();
    }

    @Test
    void shouldCalculateCorrectOrderTotal() {
        Product p1 = new Product("1", "Товар 1", 100.0);
        Product p2 = new Product("2", "Товар 2", 250.0);
        Order order = new Order("O-1", Arrays.asList(p1, p2));

        double total = storeService.calculateOrderTotal(order);

        assertEquals(350.0, total, 0.001);
    }

    @Test
    void shouldGenerateInvoiceWithCorrectData() {
        Product p1 = new Product("1", "Товар", 500.0);
        Order order = new Order("O-999", Arrays.asList(p1));

        Invoice invoice = storeService.generateInvoice(order);

        assertNotNull(invoice);
        assertEquals("O-999", invoice.getOrderId());
        assertEquals(500.0, invoice.getTotalAmount(), 0.001);
        assertTrue(invoice.getInvoiceId().startsWith("INV-"));
    }
}
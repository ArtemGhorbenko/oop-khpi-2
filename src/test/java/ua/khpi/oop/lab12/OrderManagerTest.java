package ua.khpi.oop.lab12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab12.model.*;
import ua.khpi.oop.lab12.service.OrderManager;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OrderManagerTest {
    private OrderManager manager;
    private Customer c1;
    private Order ord1, ord2;

    @BeforeEach
    void setUp() {
        c1 = new Customer("C-1", "Тест");
        Product p1 = new Product("Товар 1", "Кат 1", 100);
        Product p2 = new Product("Товар 2", "Кат 1", 200);

        ord1 = new Order("O-1", c1, Arrays.asList(p1), OrderStatus.NEW);
        ord2 = new Order("O-2", c1, Arrays.asList(p1, p2), OrderStatus.PAID);

        manager = new OrderManager(Arrays.asList(ord1, ord2));
    }

    @Test
    void testGetOrdersByStatus() {
        List<Order> newOrders = manager.getOrdersByStatus(OrderStatus.NEW);
        assertEquals(1, newOrders.size());
        assertEquals("O-1", newOrders.get(0).getOrderId());
    }

    @Test
    void testCalculateTotalRevenue() {
        double revenue = manager.calculateTotalRevenue();
        assertEquals(300.0, revenue, 0.01);
    }

    @Test
    void testGetProductCountByCategory() {
        Map<String, Long> count = manager.getProductCountByCategory();
        assertEquals(2L, count.get("Кат 1"));
    }

    @Test
    void testGetMostExpensiveOrderStream() {
        Optional<Order> mostExpensive = manager.getMostExpensiveOrderStream();
        assertTrue(mostExpensive.isPresent());
        assertEquals("O-2", mostExpensive.get().getOrderId());
    }
}
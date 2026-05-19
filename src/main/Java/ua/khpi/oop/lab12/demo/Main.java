package ua.khpi.oop.lab12.demo;

import ua.khpi.oop.lab12.model.*;
import ua.khpi.oop.lab12.service.OrderManager;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer("C-1", "Андрій Бороденко");
        Customer c2 = new Customer("C-2", "Олександр ХПІ");

        Product p1 = new Product("Ноутбук Dell", "Електроніка", 35000);
        Product p2 = new Product("Мишка Logitech", "Електроніка", 1500);
        Product p3 = new Product("Стіл офісний", "Меблі", 4200);
        Product p4 = new Product("Крісло ергономічне", "Меблі", 7800);

        List<Order> orders = Arrays.asList(
                new Order("ORD-001", c1, Arrays.asList(p1, p2), OrderStatus.PAID),
                new Order("ORD-002", c2, Arrays.asList(p3, p4), OrderStatus.DELIVERED),
                new Order("ORD-003", c1, Arrays.asList(p4), OrderStatus.NEW)
        );

        OrderManager manager = new OrderManager(orders);

        System.out.println(" 1. Усі замовлення ");
        orders.forEach(System.out::println);

        System.out.println("\n 2. Фільтрація: Замовлення зі статусом 'Нове' ");
        manager.getOrdersByStatus(OrderStatus.NEW).forEach(System.out::println);

        System.out.println("\n 3. Мапінг та Сортування: Унікальні назви товарів ");
        manager.getUniqueProductNamesSorted().forEach(name -> System.out.println("- " + name));

        System.out.println("\n 4. Агрегування: Загальна виручка (оплачені/доставлені) ");
        System.out.println("Сума: " + manager.calculateTotalRevenue() + " грн");

        System.out.println("\n 5. Групування: Замовлення по клієнтах ");
        Map<Customer, List<Order>> byCustomer = manager.groupOrdersByCustomer();
        byCustomer.forEach((customer, custOrders) -> {
            System.out.println(customer.getName() + ": " + custOrders.size() + " замовлень");
        });

        System.out.println("\n 6. Статистика: Кількість проданих товарів за категоріями ");
        manager.getProductCountByCategory().forEach((category, count) -> {
            System.out.println(category + ": " + count + " шт.");
        });

        System.out.println("\n 7. Порівняння стилів: Найдорожче замовлення ");
        System.out.println("Імперативно: " + manager.getMostExpensiveOrderImperative().getOrderId());
        manager.getMostExpensiveOrderStream().ifPresent(order ->
                System.out.println("Stream API:  " + order.getOrderId())
        );
    }
}
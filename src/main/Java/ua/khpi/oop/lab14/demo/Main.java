package ua.khpi.oop.lab14.demo;

import ua.khpi.oop.lab14.model.Order;
import ua.khpi.oop.lab14.model.Product;
import ua.khpi.oop.lab14.service.StoreService;
import ua.khpi.oop.lab14.threads.OrderProcessingTask;
import ua.khpi.oop.lab14.threads.ProductVerificationThread;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(" Lab 14: Інтернет-магазин \n");

        Product p1 = new Product("P1", "Ноутбук ASUS", 35000);
        Product p2 = new Product("P2", "Мишка Logitech", 1200);
        Product p3 = new Product("P3", "Монітор Dell", 8500);

        List<Product> catalog = Arrays.asList(p1, p2, p3);
        List<Order> orders = Arrays.asList(
                new Order("ORD-001", Arrays.asList(p1, p2)),
                new Order("ORD-002", Arrays.asList(p3))
        );

        StoreService service = new StoreService();

        ProductVerificationThread verificationThread = new ProductVerificationThread(catalog);

        OrderProcessingTask orderTask = new OrderProcessingTask(orders, service);
        Thread orderThread = new Thread(orderTask, "Order-Processor-Thread");

        System.out.println("Головний потік: Запуск паралельних завдань...\n");

        verificationThread.start();
        orderThread.start();

        try {
            verificationThread.join();
            orderThread.join();
            System.out.println("\nГоловний потік: Всі робочі потоки успішно завершили роботу!");
        } catch (InterruptedException e) {
            System.err.println("Головний потік перервано!");
            Thread.currentThread().interrupt();
        }

        System.out.println("\n Результати ");
        System.out.println("Згенеровані накладні:");
        orderTask.getGeneratedInvoices().forEach(System.out::println);

        System.out.println("\nСтатус товарів у каталозі:");
        catalog.forEach(System.out::println);
    }
}
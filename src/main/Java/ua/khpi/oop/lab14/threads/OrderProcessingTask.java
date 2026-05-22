package ua.khpi.oop.lab14.threads;

import ua.khpi.oop.lab14.model.Invoice;
import ua.khpi.oop.lab14.model.Order;
import ua.khpi.oop.lab14.service.StoreService;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class OrderProcessingTask implements Runnable {
    private final List<Order> orders;
    private final StoreService storeService;
    private final List<Invoice> generatedInvoices;

    public OrderProcessingTask(List<Order> orders, StoreService storeService) {
        this.orders = orders;
        this.storeService = storeService;
        this.generatedInvoices = new CopyOnWriteArrayList<>();
    }

    public List<Invoice> getGeneratedInvoices() {
        return generatedInvoices;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Початок обробки замовлень...");

        for (Order order : orders) {
            try {
                Thread.sleep(800);
                order.setProcessed(true);

                Invoice invoice = storeService.generateInvoice(order);
                generatedInvoices.add(invoice);

                System.out.println("[" + threadName + "] " + invoice);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
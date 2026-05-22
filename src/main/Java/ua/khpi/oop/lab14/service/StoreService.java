package ua.khpi.oop.lab14.service;

import ua.khpi.oop.lab14.model.Invoice;
import ua.khpi.oop.lab14.model.Order;
import ua.khpi.oop.lab14.model.Product;

import java.util.UUID;

public class StoreService {

    public double calculateOrderTotal(Order order) {
        return order.getProducts().stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public Invoice generateInvoice(Order order) {
        double total = calculateOrderTotal(order);
        String invoiceId = "INV-" + UUID.randomUUID().toString().substring(0, 5).toUpperCase();
        return new Invoice(invoiceId, order.getOrderId(), total);
    }
}
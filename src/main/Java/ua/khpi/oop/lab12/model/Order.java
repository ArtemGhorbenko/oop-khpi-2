package ua.khpi.oop.lab12.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final String orderId;
    private final Customer customer;
    private final List<Product> products;
    private OrderStatus status;

    public Order(String orderId, Customer customer, List<Product> products, OrderStatus status) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>(products);
        this.status = status;
    }

    public String getOrderId() { return orderId; }
    public Customer getCustomer() { return customer; }
    public List<Product> getProducts() { return products; }
    public OrderStatus getStatus() { return status; }

    public double getTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public String toString() {
        return String.format("Замовлення %s | Клієнт: %s | Статус: %s | Товарів: %d | Сума: %.2f грн",
                orderId, customer.getName(), status.getDescription(), products.size(), getTotalPrice());
    }
}
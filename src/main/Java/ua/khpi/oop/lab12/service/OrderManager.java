package ua.khpi.oop.lab12.service;

import ua.khpi.oop.lab12.model.Customer;
import ua.khpi.oop.lab12.model.Order;
import ua.khpi.oop.lab12.model.OrderStatus;
import ua.khpi.oop.lab12.model.Product;

import java.util.*;
import java.util.stream.Collectors;

public class OrderManager {
    private final List<Order> orders;

    public OrderManager(List<Order> orders) {
        this.orders = new ArrayList<>(orders);
    }

    public List<Order> getOrdersByStatus(OrderStatus status) {
        return orders.stream()
                .filter(order -> order.getStatus() == status)
                .collect(Collectors.toList());
    }

    public List<String> getUniqueProductNamesSorted() {
        return orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .map(Product::getName)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public double calculateTotalRevenue() {
        return orders.stream()
                .filter(o -> o.getStatus() == OrderStatus.PAID || o.getStatus() == OrderStatus.DELIVERED)
                .mapToDouble(Order::getTotalPrice)
                .sum();
    }

    public Map<Customer, List<Order>> groupOrdersByCustomer() {
        return orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));
    }

    public Map<String, Long> getProductCountByCategory() {
        return orders.stream()
                .filter(o -> o.getStatus() == OrderStatus.PAID || o.getStatus() == OrderStatus.DELIVERED)
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
    }

    public Order getMostExpensiveOrderImperative() {
        if (orders.isEmpty()) return null;
        Order maxOrder = orders.get(0);
        for (Order order : orders) {
            if (order.getTotalPrice() > maxOrder.getTotalPrice()) {
                maxOrder = order;
            }
        }
        return maxOrder;
    }

    public Optional<Order> getMostExpensiveOrderStream() {
        return orders.stream()
                .max(Comparator.comparingDouble(Order::getTotalPrice));
    }
}
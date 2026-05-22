package ua.khpi.oop.lab14.model;

import java.util.List;

public class Order {
    private final String orderId;
    private final List<ua.khpi.oop.lab14.model.Product> products;
    private boolean isProcessed;

    public Order(String orderId, List<ua.khpi.oop.lab14.model.Product> products) {
        this.orderId = orderId;
        this.products = products;
        this.isProcessed = false;
    }

    public String getOrderId() { return orderId; }
    public List<ua.khpi.oop.lab14.model.Product> getProducts() { return products; }
    public boolean isProcessed() { return isProcessed; }
    public void setProcessed(boolean processed) { isProcessed = processed; }
}
package ua.khpi.oop.lab14.model;

public class Product {
    private final String id;
    private final String name;
    private final double price;
    private boolean isVerified;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isVerified = false;
    }

    public String getId() { return id; }
    public String getName() { return name; }

    public double getPrice() { return price; }

    public boolean isVerified() { return isVerified; }
    public void setVerified(boolean verified) { isVerified = verified; }

    @Override
    public String toString() {
        return String.format("Товар '%s' (%.2f грн) - %s", name, price, isVerified ? "Перевірено" : "Очікує перевірки");
    }
}
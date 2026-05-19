package ua.khpi.oop.lab12.model;

public enum OrderStatus {
    NEW("Нове"),
    PAID("Оплачено"),
    SHIPPED("Відправлено"),
    DELIVERED("Доставлено");

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
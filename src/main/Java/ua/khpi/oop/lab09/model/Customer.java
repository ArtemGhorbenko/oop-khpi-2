package ua.khpi.oop.lab09.model;

public class Customer {
    private final String id;
    private final String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Клієнт{" + "id='" + id + "', ім'я='" + name + "'}";
    }
}
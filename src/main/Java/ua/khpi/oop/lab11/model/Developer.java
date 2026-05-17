package ua.khpi.oop.lab11.model;

import java.util.Objects;

public class Developer {
    private final String id;
    private final String name;

    public Developer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Developer developer = (Developer) obj;
        return id.equals(developer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", id, name);
    }
}
package ua.khpi.oop.lab10.demo;

import ua.khpi.oop.lab09.model.Customer;
import ua.khpi.oop.lab09.model.Room;
import ua.khpi.oop.lab09.model.BookingRecord;
import ua.khpi.oop.lab10.container.BookingContainer;

public class Main {
    public static void main(String[] args) {
        BookingContainer<Room> roomRegistry = new BookingContainer<>();

        roomRegistry.add(new Room("101", 2));
        roomRegistry.add(new Room("102", 4));
        roomRegistry.add(new Room("303", 1));

        System.out.println("--- Реєстр доступних номерів ---");
        for (Room room : roomRegistry) {
            System.out.println(room);
        }

        System.out.println("\n--- Облік записів бронювання ---");
        BookingContainer<BookingRecord<Customer, Room>> bookingRegistry = new BookingContainer<>();

        Customer customer = new Customer("C-777", "Горбенко А.О.");
        bookingRegistry.add(new BookingRecord<>(customer, new Room("VIP-1", 2), "Підтверджено"));

        for (BookingRecord<Customer, Room> record : bookingRegistry) {
            System.out.println(record);
        }
    }
}
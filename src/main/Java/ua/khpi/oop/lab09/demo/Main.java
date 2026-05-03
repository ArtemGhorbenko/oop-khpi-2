package ua.khpi.oop.lab09.demo;

import ua.khpi.oop.lab09.model.*;
import ua.khpi.oop.lab09.util.BookingUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("C-001", "Олександр");
        Room room = new Room("101", 2);
        Reservation reservation = new Reservation("RES-999", "2026-05-10");

        System.out.println("--- Демонстрація Generic-класу ---");

        BookingRecord<Customer, Room> roomBooking = new BookingRecord<>(customer, room, "ЗАСЕЛЕНО");
        System.out.println(roomBooking);

        BookingRecord<Customer, Reservation> abstractBooking = new BookingRecord<>(customer, reservation, "ОЧІКУЄ ОПЛАТИ");
        System.out.println(abstractBooking);

        System.out.println("\n--- Демонстрація Generic-методу ---");

        List<Room> rooms = List.of(
                new Room("101", 2),
                new Room("102", 4), // Найбільша
                new Room("103", 1)
        );

        Room biggestRoom = BookingUtils.findMaximum(rooms);
        System.out.println("Найбільша кімната: " + biggestRoom);

        List<Integer> numbers = List.of(10, 50, 25);
        System.out.println("Найбільше число: " + BookingUtils.findMaximum(numbers));
    }
}
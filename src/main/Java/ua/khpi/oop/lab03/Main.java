package ua.khpi.oop.lab03;

public class Main {
    public static void main(String[] args) {
        Guest guest1 = new Guest("G-101", "Олександр Іваненко");

        Room room101 = new Room("101");
        StandardRoom room102 = new StandardRoom("102", true, 2);
        SuiteRoom room201 = new SuiteRoom("201", true, true);

        Room room101Copy = new Room("101", false);

        System.out.println("--- До бронювання ---");
        System.out.println(room101);

        room101.bookBy(guest1);

        System.out.println("\n--- Після бронювання ---");
        System.out.println(guest1);
        System.out.println(room101);
        System.out.println(room201);

        System.out.println("\n--- Перевірка equals() та hashCode() ---");
        System.out.println("room101 equals room101Copy: " + room101.equals(room101Copy));
        System.out.println("hashCode room101: " + room101.hashCode());
        System.out.println("hashCode room101Copy: " + room101Copy.hashCode());
    }
}
package ua.khpi.oop.lab02;

public class Main {
    public static void main(String[] args) {
        Guest guest1 = new Guest("G-101", "Олександр Іваненко");
        Guest guest2 = new Guest("G-102", "Марія Коваленко");

        StandardRoom room102 = new StandardRoom("102", true, 2);
        SuiteRoom room201 = new SuiteRoom("201", true, true);

        System.out.println("--- Стан готелю зранку ---");
        System.out.println(room102);
        System.out.println(room201);

        room102.bookBy(guest1);
        room201.bookBy(guest2);

        System.out.println("\n--- Стан після заселення (Асоціація в дії) ---");
        System.out.println(room102);
        System.out.println(room201);

        room102.releaseRoom();

        System.out.println("\n--- Після виселення з кімнати 102 ---");
        System.out.println(room102);
    }
}
package ua.khpi.oop.lab05.demo;

import org.openjdk.jol.info.ClassLayout;
import ua.khpi.oop.lab05.model.CardiacSurgeon;

public class Lab05JolDemo {
    public static void main(String[] args) {
        CardiacSurgeon surgeon = new CardiacSurgeon("Олег", 10, "MED-777", 50, "International");
        System.out.println(ClassLayout.parseInstance(surgeon).toPrintable());
    }
}
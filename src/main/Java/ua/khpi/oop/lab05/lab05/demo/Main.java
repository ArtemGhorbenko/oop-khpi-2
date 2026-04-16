package ua.khpi.oop.lab05.demo;

import ua.khpi.oop.lab05.model.*;

public class Main {
    public static void main(String[] args) {
        MedicalWorker worker = new MedicalWorker("Іван Іванов", 5);
        Doctor doctor = new Doctor("Петро Петров", 10, "MED-12345");
        Surgeon surgeon = new Surgeon("Анна Скальпель", 8, "MED-111", 45);
        CardiacSurgeon cSurgeon = new CardiacSurgeon("Олександр Серцевий", 15, "MED-999", 120, "Вища категорія");
        Pediatrician pediatrician = new Pediatrician("Марія Дитяча", 7, "MED-555", 18);

        System.out.println(worker.description());
        System.out.println(doctor.description());
        System.out.println(surgeon.description());
        System.out.println(cSurgeon.description());
        System.out.println(pediatrician.description());
    }
}
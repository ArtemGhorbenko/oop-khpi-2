package ua.khpi.oop.lab07.demo;

import ua.khpi.oop.lab07.contracts.*;
import ua.khpi.oop.lab07.model.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Сповіщення (Notifiable) ---");
        Notifiable[] notifiables = {
                new ExamReminder("ООП"),
                new ConsultationSlot("О.І. Бутурлакін")
        };
        for (Notifiable item : notifiables) {
            System.out.println(item.sendNotification("Студент Іван"));
        }

        System.out.println("\n--- Планування (Schedulable) ---");
        Schedulable[] schedulables = {
                new RoomBooking("204-У1"),
                new ConsultationSlot("А.В. Горбенко")
        };
        for (Schedulable item : schedulables) {
            System.out.println(item.schedule("14:00"));
        }
    }
}
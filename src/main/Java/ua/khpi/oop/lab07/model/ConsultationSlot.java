package ua.khpi.oop.lab07.model;

import ua.khpi.oop.lab07.contracts.Notifiable;
import ua.khpi.oop.lab07.contracts.Schedulable;

public class ConsultationSlot implements Notifiable, Schedulable {
    private final String professorName;
    private boolean isScheduled = false;

    public ConsultationSlot(String professorName) {
        this.professorName = professorName;
    }

    @Override
    public String schedule(String time) {
        isScheduled = true;
        return "Консультація у викладача " + professorName + " призначена на " + time + ".";
    }

    @Override
    public String sendNotification(String user) {
        if (!isScheduled) {
            return "Увага, " + user + ": час консультації у викладача " + professorName + " ще не визначено.";
        }
        return "Сповіщення для " + user + ": Ваша консультація у " + professorName + " підтверджена.";
    }
}
package ua.khpi.oop.lab05.model;

public class MedicalWorker {
    private final String name;
    private int experienceYears;

    public MedicalWorker(String name, int experienceYears) {
        this.name = name;
        this.experienceYears = experienceYears;
    }

    public String getName() { return name; }
    public int getExperienceYears() { return experienceYears; }
    public void addExperience(int years) { this.experienceYears += years; }

    public String description() {
        return "Працівник: " + name + ", досвід: " + experienceYears + " р.";
    }
}
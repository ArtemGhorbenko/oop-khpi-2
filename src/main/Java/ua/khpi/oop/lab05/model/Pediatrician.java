package ua.khpi.oop.lab05.model;

public class Pediatrician extends Doctor {
    private final int maxAgeLimit;

    public Pediatrician(String name, int experienceYears, String licenseNumber, int maxAgeLimit) {
        super(name, experienceYears, licenseNumber);
        this.maxAgeLimit = maxAgeLimit;
    }

    public int getMaxAgeLimit() { return maxAgeLimit; }

    @Override
    public String description() {
        return super.description() + ", вік пацієнтів до: " + maxAgeLimit + " р.";
    }
}
package ua.khpi.oop.lab05.model;

public class Surgeon extends Doctor {
    private int successfulSurgeries;

    public Surgeon(String name, int experienceYears, String licenseNumber, int successfulSurgeries) {
        super(name, experienceYears, licenseNumber);
        this.successfulSurgeries = successfulSurgeries;
    }

    public int getSuccessfulSurgeries() { return successfulSurgeries; }
    public void addSurgery() { this.successfulSurgeries++; }

    @Override
    public String description() {
        return super.description() + ", успішних операцій: " + successfulSurgeries;
    }
}
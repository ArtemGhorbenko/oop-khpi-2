package ua.khpi.oop.lab05.model;

public class Doctor extends MedicalWorker {
    private final String licenseNumber;

    public Doctor(String name, int experienceYears, String licenseNumber) {
        super(name, experienceYears);
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseNumber() { return licenseNumber; }

    @Override
    public String description() {
        return super.description() + ", ліцензія: " + licenseNumber;
    }
}
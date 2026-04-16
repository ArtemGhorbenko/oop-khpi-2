package ua.khpi.oop.lab05.model;

public final class CardiacSurgeon extends Surgeon {
    private final String certificationLevel;

    public CardiacSurgeon(String name, int experienceYears, String licenseNumber, int successfulSurgeries, String certificationLevel) {
        super(name, experienceYears, licenseNumber, successfulSurgeries);
        this.certificationLevel = certificationLevel;
    }

    public String getCertificationLevel() { return certificationLevel; }

    @Override
    public String description() {
        return super.description() + ", сертифікація: " + certificationLevel;
    }
}
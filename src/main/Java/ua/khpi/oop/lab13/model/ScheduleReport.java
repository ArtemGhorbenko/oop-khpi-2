package ua.khpi.oop.lab13.model;

public class ScheduleReport {
    private final int totalValidRecords;
    private final int totalErrors;

    public ScheduleReport(int totalValidRecords, int totalErrors) {
        this.totalValidRecords = totalValidRecords;
        this.totalErrors = totalErrors;
    }

    public int getTotalValidRecords() { return totalValidRecords; }
    public int getTotalErrors() { return totalErrors; }
}
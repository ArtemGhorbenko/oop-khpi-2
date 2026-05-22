package ua.khpi.oop.lab14.model;

public class Invoice {
    private final String invoiceId;
    private final String orderId;
    private final double totalAmount;

    public Invoice(String invoiceId, String orderId, double totalAmount) {
        this.invoiceId = invoiceId;
        this.orderId = orderId;
        this.totalAmount = totalAmount;
    }

    public String getInvoiceId() { return invoiceId; }
    public double getTotalAmount() { return totalAmount; }

    @Override
    public String toString() {
        return String.format("Накладна %s (Замовлення: %s) на суму %.2f грн", invoiceId, orderId, totalAmount);
    }
}
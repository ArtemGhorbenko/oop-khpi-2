package ua.khpi.oop.lab09.model;

public class BookingRecord<TClient, TResource> {
    private final TClient client;
    private final TResource resource;
    private final String status;

    public BookingRecord(TClient client, TResource resource, String status) {
        this.client = client;
        this.resource = resource;
        this.status = status;
    }

    public TClient getClient() { return client; }
    public TResource getResource() { return resource; }

    @Override
    public String toString() {
        return "ЗаписБронювання {\n" +
                "  Клієнт: " + client + "\n" +
                "  Ресурс: " + resource + "\n" +
                "  Статус: " + status + "\n" +
                "}";
    }
}
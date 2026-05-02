package ua.khpi.oop.lab08.service;

import ua.khpi.oop.lab08.model.CampusService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CampusServiceRegistry implements Serializable {
    private static final long serialVersionUID = 1L;
    private final List<CampusService> services = new ArrayList<>();

    public void addService(CampusService service) {
        services.add(service);
    }

    public List<CampusService> getServices() {
        return List.copyOf(services);
    }
}
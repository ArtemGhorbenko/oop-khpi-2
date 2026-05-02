package ua.khpi.oop.lab08.model;
import java.io.Serializable;

public interface CampusService extends Serializable {
    String toTextLine();
    String getInfo();
}
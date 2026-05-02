package ua.khpi.oop.lab08.exception;

public class InvalidCampusDataException extends Exception {
    public InvalidCampusDataException(String message) {
        super(message);
    }

    public InvalidCampusDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
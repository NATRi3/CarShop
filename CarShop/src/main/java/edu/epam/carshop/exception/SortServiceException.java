package edu.epam.carshop.exception;

public class SortServiceException extends Exception {
    public SortServiceException() {
    }

    public SortServiceException(String message) {
        super(message);
    }

    public SortServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public SortServiceException(Throwable cause) {
        super(cause);
    }
}

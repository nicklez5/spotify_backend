package com.spotify66_times.exception;

public class LibraryException extends Exception {
    private static final long serialVersionUID = 1L;
    public LibraryException(String message) {
        super(message);
    }
    public LibraryException() {
        super();

    }
}

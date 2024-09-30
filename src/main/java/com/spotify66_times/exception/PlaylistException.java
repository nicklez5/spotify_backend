package com.spotify66_times.exception;

public class PlaylistException extends Exception {
    private static final long serialVersionUID = 1L;
    public PlaylistException() {
        super();
    }
    public PlaylistException(String message) {
        super(message);
    }
}

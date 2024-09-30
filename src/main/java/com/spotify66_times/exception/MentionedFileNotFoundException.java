package com.spotify66_times.exception;

public class MentionedFileNotFoundException extends Throwable {
    public MentionedFileNotFoundException(String s) {
        super(s);
        System.out.println("MentionedFileNotFoundException: " + s);
    }
    public MentionedFileNotFoundException(String s, Throwable throwable) {
        super(s, throwable);

    }
}

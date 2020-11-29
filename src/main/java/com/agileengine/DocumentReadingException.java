package com.agileengine;

public class DocumentReadingException extends RuntimeException {
    public DocumentReadingException(String fileName) {
        super(String.format("Error reading the file %s", fileName));
    }
}

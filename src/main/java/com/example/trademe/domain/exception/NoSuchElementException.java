package com.example.trademe.domain.exception;

public class NoSuchElementException extends RuntimeException{
    private NoSuchElementException(String message) { super(message); }
    public static NoSuchElementException withId(int id) {
        return new NoSuchElementException(String.format("No element found with ID %d", id));
    }
}


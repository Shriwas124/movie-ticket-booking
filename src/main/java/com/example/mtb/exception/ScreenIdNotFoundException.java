package com.example.mtb.exception;

public class ScreenIdNotFoundException extends RuntimeException{
    public ScreenIdNotFoundException(String message) {
        super(message);
    }
}

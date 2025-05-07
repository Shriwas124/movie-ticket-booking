package com.example.mtb.exception;

public class TheaterNotFoundByIdException extends RuntimeException{
    public TheaterNotFoundByIdException(String message) {
        super(message);
    }
}

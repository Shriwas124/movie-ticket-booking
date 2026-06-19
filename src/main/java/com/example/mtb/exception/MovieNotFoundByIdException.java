package com.example.mtb.exception;

public class MovieNotFoundByIdException extends RuntimeException{
    public MovieNotFoundByIdException(String message) {
        super(message);
    }
}

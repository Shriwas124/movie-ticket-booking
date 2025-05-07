package com.example.mtb.exception;

public class ScreenNotFoundByIdException extends RuntimeException{
    public ScreenNotFoundByIdException(String message) {
        super(message);
    }
}

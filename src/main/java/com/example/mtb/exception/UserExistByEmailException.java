package com.example.mtb.exception;

public class UserExistByEmailException extends  RuntimeException{
    private String message;

    public UserExistByEmailException(String message) {
        this.message = message;
    }
}

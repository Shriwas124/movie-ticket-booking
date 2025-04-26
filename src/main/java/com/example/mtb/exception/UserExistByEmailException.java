package com.example.mtb.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
public class UserExistByEmailException extends  RuntimeException{
    private String message;

    public UserExistByEmailException(String message) {
        super(message);
    }
}

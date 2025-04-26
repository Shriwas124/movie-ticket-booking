package com.example.mtb.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
public class UserDetailsNotFoundException extends RuntimeException {
    private String message;



    public UserDetailsNotFoundException(String message) {
        super(message);
    }


}

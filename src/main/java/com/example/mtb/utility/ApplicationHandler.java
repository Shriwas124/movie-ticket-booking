package com.example.mtb.utility;

import com.example.mtb.exception.UserDetailsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> handleUserDetailNotFoundException(UserDetailsNotFoundException ex) {
        ErrorStructure<String> errorStructure = new ErrorStructure<>();
        errorStructure.setErrorstatus(HttpStatus.NOT_FOUND.value());
        errorStructure.setErrormessage(ex.getMessage());
        errorStructure.setError("User detail not found");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorStructure);
    }
}

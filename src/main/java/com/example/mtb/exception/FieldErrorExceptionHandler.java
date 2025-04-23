package com.example.mtb.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        List<CustomFieldError> fieldErrors = new ArrayList<>();

        for (ObjectError objectError : ex.getAllErrors()) {
            if (objectError instanceof FieldError fieldError) {
                fieldErrors.add(
                        CustomFieldError.builder()
                                .field(fieldError.getField())
                                .rejectedvalue(fieldError.getRejectedValue())
                                .errorMessage(fieldError.getDefaultMessage())
                                .build()
                );
            }
        }

        ErrorResponseStructure response = ErrorResponseStructure.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message("Validation failed")
                .errors(fieldErrors)
                .build();

        return new ResponseEntity<>(response, headers, HttpStatus.BAD_REQUEST);
    }

    @Builder
    @Getter
    public static class CustomFieldError {
        String field;
        Object rejectedvalue;
        String errorMessage;
    }

    @Builder
    @Getter
    public static class ErrorResponseStructure {
        int status;
        String message;
        List<CustomFieldError> errors;
    }
}

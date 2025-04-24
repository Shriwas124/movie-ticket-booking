package com.example.mtb.configuration;


import com.example.mtb.utility.ResponseStructure;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;



@Component
public class RestResponseBuilder {

    public <T> ResponseEntity<ResponseStructure<T>> success(
            @NotNull HttpStatus status, String message, T data) {

        ResponseStructure<T> responseStructure = ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(status).body(responseStructure);
    }

    public static <T> ResponseEntity<ResponseStructure<T>> create(
            @NotNull HttpStatus status, String message, T data) {

        ResponseStructure<T> responseStructure = ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(status).body(responseStructure);

    }

    public static <T> ResponseEntity<ResponseStructure<T>> update(
            @NotNull HttpStatus status, String message, T data) {

        ResponseStructure<T> responseStructure = ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(status).body(responseStructure);

    }
    public static <T> ResponseEntity<ResponseStructure<T>> delete(
            @NotNull HttpStatus status, String message, T data) {

        ResponseStructure<T> responseStructure = ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(status).body(responseStructure);

}


package com.example.mtb.utility;


import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RestResponsecrack {

    @Bean
    public <T>ResponseEntity<ResponseStructure<T>> sucess(HttpStatus status, String message, T data){
        ResponseStructure<T> responseStructure = ResponseStructure.<T>builder().status(status.value()).message(message).data(data).build();
        return  ResponseEntity.status(status).body(responseStructure);

    }
}

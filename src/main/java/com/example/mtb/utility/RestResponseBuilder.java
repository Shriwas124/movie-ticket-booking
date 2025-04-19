package com.example.mtb.utility;


import jakarta.validation.constraints.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RestResponseBuilder {

   @Bean
    public <T>ResponseEntity<ResponseStructure<T>> sucess(@NotNull HttpStatus status, String message, T data){
        ResponseStructure<T> responseStructure = ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();
        return  ResponseEntity.status(status).body(responseStructure);

    }


}

package com.example.mtb.utility;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FieldErrorStructure<T> {

    private  int statuscode;

    @JsonProperty("error_message")
    private String  errorMessage;

    T data;
}

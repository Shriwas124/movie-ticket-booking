package com.example.mtb.utility;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorStructure<T> {

    private int errorstatus;
    private String errormessage;
    private T error;


}

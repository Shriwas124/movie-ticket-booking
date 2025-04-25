package com.example.mtb.controller;

import com.example.mtb.configuration.RestResponseBuilder;
import com.example.mtb.dto.request.TheaterRegisterRequest;
import com.example.mtb.dto.response.TheaterResponse;
import com.example.mtb.service.TheaterService;
import com.example.mtb.serviceimpl.TheaterServiceImpl;
import com.example.mtb.utility.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TheaterController {
    private final TheaterServiceImpl theaterService;

    @PostMapping("/theater")
    public ResponseEntity<ResponseStructure<TheaterResponse>> addTheater(@Valid @RequestParam String email, @Valid @RequestBody TheaterRegisterRequest theaterRegisterRequest){
        TheaterResponse theaterResponse = theaterService.addTheater(email, theaterRegisterRequest);
       return RestResponseBuilder.create("UserDetail Created",theaterResponse,201);
    }
}




































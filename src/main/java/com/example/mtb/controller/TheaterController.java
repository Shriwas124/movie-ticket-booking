package com.example.mtb.controller;

import com.example.mtb.configuration.RestResponseBuilder;
import com.example.mtb.dto.request.TheaterRequest;
import com.example.mtb.dto.response.TheaterResponse;
import com.example.mtb.serviceimpl.TheaterServiceImpl;
import com.example.mtb.utility.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TheaterController {
    private final TheaterServiceImpl theaterService;

    @PostMapping("/create")
    public ResponseEntity<ResponseStructure<TheaterResponse>> addTheater(@RequestBody TheaterRequest theaterRequest, @Valid @RequestParam String email){
        TheaterResponse createtheater = theaterService.addTheater(email, theaterRequest);
       return RestResponseBuilder.create("Theater created Created",createtheater,201);
    }

    @GetMapping("/theater/id")
    public ResponseEntity<ResponseStructure<TheaterResponse>> findTheater(@Valid @RequestParam String id){
        TheaterResponse findTheater = theaterService.findTheater(id);
        return RestResponseBuilder.ok("find the id",findTheater,201);
    }

    @PutMapping("/theater/update")
    public ResponseEntity<ResponseStructure<TheaterResponse>> updateTheater(@Valid @RequestParam String id, @RequestBody TheaterRequest theaterRequest){
        TheaterResponse updateTheater = theaterService.updateTheater(id,theaterRequest);
        return RestResponseBuilder.ok("Theater Updated",updateTheater,201);
    }

}




































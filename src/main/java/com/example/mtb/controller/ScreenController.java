package com.example.mtb.controller;

import com.example.mtb.configuration.RestResponseBuilder;
import com.example.mtb.dto.request.ScreenRequest;
import com.example.mtb.dto.response.ScreenResponse;
import com.example.mtb.dto.response.ScreenResponseList;
import com.example.mtb.serviceimpl.ScreenServiceImpl;
import com.example.mtb.utility.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ScreenController {

    private final ScreenServiceImpl screenService;

    @PostMapping("/screen")
    public ResponseEntity<ResponseStructure<ScreenResponse>> addScreen(@Valid @RequestParam String theaterId, @RequestBody ScreenRequest screenRequest){
        ScreenResponse addScreen = screenService.addScreen(theaterId,screenRequest);
        return RestResponseBuilder.create("Screen Created" ,addScreen,201);


    }

    @GetMapping("/screen/id")
    public ResponseEntity<ResponseStructure<ScreenResponseList>> findScreen(@Valid @RequestParam String screenId){
        ScreenResponseList findScreen = screenService.findScreen(screenId);
        return RestResponseBuilder.ok("Screen Found",findScreen,201);
    }
}

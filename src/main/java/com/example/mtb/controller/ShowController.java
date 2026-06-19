package com.example.mtb.controller;

import com.example.mtb.configuration.RestResponseBuilder;
import com.example.mtb.dto.response.ShowResponse;
import com.example.mtb.service.ShowService;
import com.example.mtb.utility.ResponseStructure;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ShowController {

    private final ShowService showService;

    @PostMapping("/show")
    public ResponseEntity<ResponseStructure<ShowResponse>> addShow(
            @PathVariable String theaterId,
            @PathVariable String screenId,
            @RequestParam String movieId,
            @RequestParam @NotNull Long startTime) {
        ShowResponse showResponse = showService.addShow(theaterId, screenId, movieId, startTime);
        return RestResponseBuilder.create("Screen Created", showResponse, 201);
    }

}

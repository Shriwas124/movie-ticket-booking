package com.example.mtb.controller;


import com.example.mtb.configuration.RestResponseBuilder;
import com.example.mtb.dto.request.FeedbackRequest;
import com.example.mtb.dto.response.FeedbackResponse;
import com.example.mtb.service.FeedbackService;
import com.example.mtb.utility.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class FeedbackController {


    private final FeedbackService feedbackService;


    @PostMapping("/feedback")
    public ResponseEntity<ResponseStructure<FeedbackResponse>> createfeedback(@RequestBody FeedbackRequest feedback, @RequestParam String userId, @RequestParam String movieId){

        FeedbackResponse feedbackResponse=feedbackService.createFeedBack(feedback, userId, movieId);

        return RestResponseBuilder.create("feedback created" ,feedbackResponse,201);


    }
}

package com.example.mtb.service;

import com.example.mtb.dto.request.FeedbackRequest;
import com.example.mtb.dto.response.FeedbackResponse;
import com.example.mtb.serviceimpl.FeedbackServiceImpl;
import jakarta.validation.Valid;

public interface FeedbackService{



    FeedbackResponse createFeedBack(FeedbackRequest feedback, String userId, String movieId);
}
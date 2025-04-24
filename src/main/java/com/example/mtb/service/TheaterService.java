package com.example.mtb.service;

import com.example.mtb.dto.request.TheaterRegisterRequest;
import com.example.mtb.dto.response.TheaterResponse;
import jakarta.validation.Valid;

public interface TheaterService {
    TheaterResponse addTheater(String email, @Valid TheaterRegisterRequest theaterRegisterRequest);
}

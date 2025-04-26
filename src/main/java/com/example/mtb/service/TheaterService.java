package com.example.mtb.service;

import com.example.mtb.dto.request.TheaterRequest;
import com.example.mtb.dto.response.TheaterResponse;
import jakarta.validation.Valid;

public interface TheaterService {
    TheaterResponse addTheater(@Valid String email,@Valid TheaterRequest theaterRequest);

    TheaterResponse findTheater(@Valid String id);

    TheaterResponse updateTheater(@Valid String id, TheaterRequest updatedtheater);
}

package com.example.mtb.service;

import com.example.mtb.dto.request.ScreenRequest;
import com.example.mtb.dto.response.ScreenResponse;
import com.example.mtb.dto.response.ScreenResponseList;
import jakarta.validation.Valid;

public interface ScreenService {
    ScreenResponse addScreen(@Valid String theaterId, ScreenRequest screenRequest);

    ScreenResponseList findScreen(@Valid String screenId);
}

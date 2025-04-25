package com.example.mtb.mapper;

import com.example.mtb.dto.response.TheaterResponse;
import com.example.mtb.entity.Theater;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

@Component
public class TheaterMapper {
    public TheaterResponse theaterResponseMapper(Theater theater) {
        if (theater == null)
            return null;
        return new TheaterResponse(
                theater.getName(),
                theater.getAddress(),
                theater.getCity(),
                theater.getLandmark()
        );
    }




}

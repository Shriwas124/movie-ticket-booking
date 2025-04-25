package com.example.mtb.dto.response;

import lombok.Builder;


public record TheaterResponse(

        String name,
        String address,
        String city,
        String landmark
) {
}

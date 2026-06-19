package com.example.mtb.dto.response;

import java.time.Instant;

public record ShowResponse(

        String showId,
        Instant startsAt,
        Instant endsAt
) {
}

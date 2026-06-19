package com.example.mtb.dto.request;

public record LoginRequest(
        String email,
        String password
) {
}

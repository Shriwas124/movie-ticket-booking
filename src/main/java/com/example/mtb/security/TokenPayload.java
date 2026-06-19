package com.example.mtb.security;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;


import java.time.Instant;
import java.util.Map;

public record TokenPayload(
        Map<String, Object> Claims,
        String Subject,
        Instant IssuedAt,
        Instant Expiration
) {}

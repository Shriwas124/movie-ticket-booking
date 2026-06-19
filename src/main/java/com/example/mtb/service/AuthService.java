package com.example.mtb.service;

import com.example.mtb.dto.request.LoginRequest;

public interface AuthService {
    String login(LoginRequest loginRequest);
}

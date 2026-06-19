package com.example.mtb.controller;


import com.example.mtb.dto.request.LoginRequest;
import com.example.mtb.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    public ResponseEntity<String> login(@RequestBody  LoginRequest loginRequest){
           String jwtTokens = authService.login(loginRequest);
           return ResponseEntity.ok(jwtTokens);
    }
}

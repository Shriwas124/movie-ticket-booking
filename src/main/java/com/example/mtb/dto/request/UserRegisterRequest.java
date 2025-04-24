package com.example.mtb.dto.request;

import com.example.mtb.enums.UserRoles;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public record UserRegisterRequest(
       @NotNull
        String username,
        @NotNull
        String email,
        @NotNull
        String password,
        @NotNull
        String phoneNumber,
        @NotNull
        UserRoles userRole,
        @NotNull
        LocalDate dateOfBirth

) {}

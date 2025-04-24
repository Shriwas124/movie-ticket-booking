package com.example.mtb.dto.request;

import com.example.mtb.enums.UserRoles;

import java.time.LocalDate;

public record UserRequest(String username,
    String phoneNumber,
    LocalDate dateofBirth,
        UserRoles userRoles
)
{
}

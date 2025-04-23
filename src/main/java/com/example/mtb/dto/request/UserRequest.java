package com.example.mtb.dto.request;

import com.example.mtb.enums.UserRoles;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public record UserRequest(String username,
    String phoneNumber,
    LocalDate dateofBirth,
        UserRoles userRoles
)
{
}

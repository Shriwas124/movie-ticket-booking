package com.example.mtb.dto.response;

import com.example.mtb.enums.UserRoles;

public record UserRegisterResponse(
        String userId,
        String username,
        String email,
        UserRoles userRoles

){
}

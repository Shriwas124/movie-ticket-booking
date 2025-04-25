package com.example.mtb.service;

import com.example.mtb.dto.request.UserRegisterRequest;
import com.example.mtb.dto.request.UserRequest;
import com.example.mtb.dto.response.UserRegisterResponse;
import com.example.mtb.entity.UserDetails;
import jakarta.validation.Valid;


public interface UserService {




    UserRegisterResponse addUserDetails(UserRegisterRequest userDetails);

    UserRegisterResponse updating( String email,UserRequest request);

    void softDelete(@Valid String email);
}


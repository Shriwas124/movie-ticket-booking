package com.example.mtb.controller;

import com.example.mtb.configuration.RestResponseBuilder;
import com.example.mtb.dto.request.UserRegisterRequest;
import com.example.mtb.dto.request.UserRequest;
import com.example.mtb.dto.response.UserRegisterResponse;
import com.example.mtb.serviceimpl.UserServiceImpl;
import com.example.mtb.utility.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@AllArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/user")
    public ResponseEntity<ResponseStructure<UserRegisterResponse>> addUserDetails( @Valid @RequestBody UserRegisterRequest userDetails) {
        UserRegisterResponse savedUser = userService.addUserDetails(userDetails);
        return  RestResponseBuilder.create(HttpStatus.CREATED ,"user object created",savedUser );
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseStructure<UserRegisterResponse>> updating(@Valid @RequestBody UserRequest request, String email){
        UserRegisterResponse update = userService.updating(request,email);
        return  RestResponseBuilder.update(HttpStatus.OK,"user object updated",update);

    }
}

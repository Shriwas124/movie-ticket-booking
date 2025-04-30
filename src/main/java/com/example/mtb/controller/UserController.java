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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserServiceImpl userService;


    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserRegisterResponse>> addUserDetails( @Valid @RequestBody UserRegisterRequest userDetails) {
        UserRegisterResponse savedUser = userService.addUserDetails(userDetails);
         return RestResponseBuilder.create("UserDetail Created", savedUser, 201);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseStructure<UserRegisterResponse>> updating(@Valid @RequestParam String email,@RequestBody UserRequest request){
        UserRegisterResponse update = userService.updating( email,request);
        return RestResponseBuilder.update("User profile updated successfully",update,200);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseStructure<String>> deleteuser(@Valid @RequestParam String email){
        userService.softDelete(email);
        return RestResponseBuilder.ok("User account deleted successfully (soft delete).", null, 204);
    }
}

package com.example.mtb.controller;

import com.example.mtb.entity.UserDetails;


import com.example.mtb.serviceimpl.UserServiceImpl;
import com.example.mtb.utility.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
@AllArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/user")
    public ResponseEntity<ResponseStructure<UserDetails>> adduserDetails(UserDetails userDetails){
        UserDetails user1 = userService.addUserDetails(userDetails);
        ResponseStructure<UserDetails> responseStructure =ResponseStructure.<UserDetails>builder()
                .status(HttpStatus.CREATED.value())
                .message("the new user will added")
                .data(user1)
                .build();
        return new ResponseEntity<>(responseStructure,HttpStatus.CREATED);

    }

}


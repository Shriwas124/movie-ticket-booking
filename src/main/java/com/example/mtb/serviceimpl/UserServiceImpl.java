package com.example.mtb.serviceimpl;

import com.example.mtb.dto.request.UserRegisterRequest;
import com.example.mtb.dto.request.UserRequest;
import com.example.mtb.dto.response.UserRegisterResponse;
import com.example.mtb.entity.TheaterOwner;
import com.example.mtb.entity.User;
import com.example.mtb.entity.UserDetails;
import com.example.mtb.exception.UserDetailsNotFoundException;
import com.example.mtb.exception.UserExistByEmailException;
import com.example.mtb.repository.UserDetailsRepository;
import com.example.mtb.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;


@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserDetailsRepository userDetailsRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserRegisterResponse addUserDetails(UserRegisterRequest request) {
        if (userDetailsRepository.existsByEmail(request.email())) {
            throw new UserExistByEmailException("User with Email already exists");
        }

        UserDetails savedUser = switch (request.userRole()) {
            case USER -> saveUser(new User(), request);
            case THEATER_OWNER -> saveUser(new TheaterOwner(), request);
        };

        return new UserRegisterResponse(
                savedUser.getUserId(),
                savedUser.getUsername(),
                savedUser.getEmail(),
                savedUser.getUserRoles()

        );
    }
    private UserDetails saveUser(UserDetails target, UserRegisterRequest source) {
        target.setUserRoles(source.userRole());
        target.setUsername(source.username());
        target.setEmail(source.email());
        target.setPassword(passwordEncoder.encode(source.password()));
        target.setPhoneNumber(source.phoneNumber());
        target.setDateofbirth(source.dateOfBirth());
        return userDetailsRepository.save(target);
    }



    @Override
    public UserRegisterResponse updating( String email,UserRequest request) {
        UserDetails user =  userDetailsRepository.findByEmail(email)
                .orElseThrow(() -> new UserDetailsNotFoundException("user not found"));

        user.setUsername(request.username());
        user.setPhoneNumber(request.phoneNumber());
        user.setDateofbirth(request.dateofBirth());
        user.setUpdatedAt(Instant.ofEpochMilli(System.currentTimeMillis()));

        userDetailsRepository.save(user);

        return new UserRegisterResponse(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getUserRoles()
        );
    }

    @Override
    public void softDelete(String email) {
        UserDetails user = userDetailsRepository.findByEmail(email)
                .orElseThrow(() -> new UserDetailsNotFoundException("user not found" + email));

        if (user.isDeleted()) {
            throw new IllegalStateException("User is already deleted: ");
        }

        user.setDeleted(true);
        user.setDeletedAt(Instant.now());
        userDetailsRepository.save(user);
    }


}






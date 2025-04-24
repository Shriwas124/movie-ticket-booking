package com.example.mtb.serviceimpl;

import com.example.mtb.dto.request.UserRegisterRequest;
import com.example.mtb.dto.request.UserRequest;
import com.example.mtb.dto.response.UserRegisterResponse;
import com.example.mtb.entity.TheaterOwner;
import com.example.mtb.entity.User;
import com.example.mtb.entity.UserDetails;
import com.example.mtb.exception.UserDetailsNotFoundException;
import com.example.mtb.exception.UserExistByEmailException;
import com.example.mtb.repository.UserRepository;
import com.example.mtb.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.mtb.enums.UserRoles.THEATER_OWNER;

import java.time.LocalDateTime;

import static com.example.mtb.enums.UserRoles.THEATER_OWNER;
import static org.hibernate.cfg.JdbcSettings.USER;


@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public UserRegisterResponse addUserDetails(UserRegisterRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new UserExistByEmailException("User with Email already exists");
        }

        UserDetails savedUser = switch (request.userRole()) {//using Switch case
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
        target.setPassword(source.password());
        target.setPhoneNumber(source.phoneNumber());
        target.setDateofbirth(source.dateOfBirth());
        return userRepository.save(target);
    }

    @Override
    public UserRegisterResponse updating(UserRequest request, String email) {
        UserDetails user =  userRepository.findByEmail(email)
                .orElseThrow(() -> new UserDetailsNotFoundException("user not found"));

        user.setUsername(request.username());
        user.setPhoneNumber(request.phoneNumber());
        user.setDateofbirth(request.dateofBirth());
        user.setUserRoles(request.userRoles());

        userRepository.save(user);

        return new UserRegisterResponse(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getUserRoles()
        );
    }

    @Override
    public void softDelete(String email) {
        UserDetails user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserDetailsNotFoundException("user not found" + email));

        if (user.isDeleted()) {
            throw new IllegalStateException("User is already deleted: " + email);
        }

        user.setDeleted(true);
        userRepository.save(user);
    }
}






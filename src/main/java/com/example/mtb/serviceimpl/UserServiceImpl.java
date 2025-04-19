package com.example.mtb.serviceimpl;

import com.example.mtb.entity.UserDetails;
import com.example.mtb.repository.UserRepository;
import com.example.mtb.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserDetails addUserDetails(UserDetails userDetails) {
        return  userRepository.save(userDetails);
    }
}

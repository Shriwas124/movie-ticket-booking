package com.example.mtb.security;

import com.example.mtb.exception.UserDetailsNotFoundException;
import com.example.mtb.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
           com.example.mtb.entity.UserDetails user = userRepository.findByEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Username not found :" +username));


        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getUserRoles().name())
                .build();
    }
}

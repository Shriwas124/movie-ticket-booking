package com.example.mtb.serviceimpl;

import com.example.mtb.dto.request.TheaterRegisterRequest;
import com.example.mtb.dto.response.TheaterResponse;
import com.example.mtb.entity.Theater;
import com.example.mtb.entity.TheaterOwner;
import com.example.mtb.entity.UserDetails;
import com.example.mtb.exception.UserDetailsNotFoundException;
import com.example.mtb.mapper.TheaterMapper;
import com.example.mtb.repository.TheaterRepository;
import com.example.mtb.repository.UserRepository;
import com.example.mtb.service.TheaterService;
import jdk.internal.net.http.common.Utils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TheaterServiceImpl implements TheaterService {
private final UserRepository userRepository;
private final TheaterRepository theaterRepository;
private final TheaterMapper theaterMapper;

    @Override
    public TheaterResponse addTheater(String email, TheaterRegisterRequest theaterRegisterRequest) {

        if(userRepository.existsByEmail(email) && userRepository.findByEmail(email).getUserRoles() == UserRole.THEATER_OWNER ){
            Optional<UserDetails> user = userRepository.findByEmail(email);
            Theater theater = saving(theaterRegisterRequest, new Theater(), user);
            return theaterMapper.theaterResponseMapper(theater);
        }
        throw new UserDetailsNotFoundException("No Theater Owner with the provided email is present");
    }

    private Theater saving(TheaterRegisterRequest registerationRequest, Theater theater , UserDetails userDetails){
        theater.setAddress(registerationRequest.address());
        theater.setCity(registerationRequest.city());
        theater.setName(registerationRequest.name());
        theater.setLandmark(registerationRequest.landmark());
        theater.setTheaterOwner((TheaterOwner) userDetails);
        theaterRepository.save(theater);
        return theater;


    }
}

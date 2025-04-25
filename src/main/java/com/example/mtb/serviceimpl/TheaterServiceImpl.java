package com.example.mtb.serviceimpl;

import com.example.mtb.dto.request.TheaterRegisterRequest;
import com.example.mtb.dto.response.TheaterResponse;
import com.example.mtb.entity.Theater;
import com.example.mtb.entity.TheaterOwner;
import com.example.mtb.entity.UserDetails;
import com.example.mtb.enums.UserRoles;
import com.example.mtb.exception.UserDetailsNotFoundException;
import com.example.mtb.exception.UserNotFoundByEmailException;
import com.example.mtb.repository.TheaterOwnerRepos;
import com.example.mtb.repository.TheaterRepository;
import com.example.mtb.repository.UserRepository;
import com.example.mtb.service.TheaterService;
import com.example.mtb.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@AllArgsConstructor
@Service
public class TheaterServiceImpl implements TheaterService{
private final UserRepository userRepository;
private  final TheaterRepository theaterRepository;
private final TheaterOwnerRepos theaterOwnerRepos;

    @Override
    public TheaterResponse addTheater(String email, TheaterRegisterRequest theaterRegisterRequest) {

        Optional<UserDetails> optionalUserDetails = userRepository.findByEmail(email);
        if (optionalUserDetails.isEmpty()) {
            throw new UserNotFoundByEmailException("user not found in this email");
        } else {
            UserDetails userDetails = optionalUserDetails.get();
            if (userDetails.getUserRoles() != UserRoles.THEATER_OWNER) {
                throw new UserNotFoundByEmailException("this user not theater owner");
            } else {
                Theater newTheater = new Theater();
                newTheater.setName(theaterRegisterRequest.name());
                newTheater.setAddress(theaterRegisterRequest.address());
                newTheater.setCity(theaterRegisterRequest.city());
                newTheater.setLandmark(theaterRegisterRequest.landmark());
                //newTheater.setCreatedBy(userDetails.getUserId());

                newTheater.setTheaterOwner((TheaterOwner) userDetails);

                List<Theater> theaterList = new ArrayList<Theater>();
                theaterList.add(newTheater);

                TheaterOwner theaterOwner = new TheaterOwner();
                theaterOwner.setTheaters(theaterList);

                theaterOwnerRepos.save(theaterOwner);
                theaterRepository.save(newTheater);
                return new TheaterResponse(
                        newTheater.getName(),
                        newTheater.getAddress(),
                        newTheater.getCity(),
                        newTheater.getLandmark()
                );
            }
        }
    }
}
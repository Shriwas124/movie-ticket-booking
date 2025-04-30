package com.example.mtb.serviceimpl;

import ch.qos.logback.core.status.InfoStatus;
import com.example.mtb.dto.request.TheaterRequest;
import com.example.mtb.dto.response.TheaterResponse;
import com.example.mtb.entity.Theater;
import com.example.mtb.entity.TheaterOwner;
import com.example.mtb.entity.UserDetails;
import com.example.mtb.enums.UserRoles;
import com.example.mtb.exception.TheaterOwnerIdException;
import com.example.mtb.exception.UserNotFoundByEmailException;
import com.example.mtb.repository.TheaterOwnerRepos;
import com.example.mtb.repository.TheaterRepository;
import com.example.mtb.repository.UserRepository;
import com.example.mtb.service.TheaterService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class TheaterServiceImpl implements TheaterService {
    private final UserRepository userRepository;
    private final TheaterRepository theaterRepository;
    private final TheaterOwnerRepos theaterOwnerRepos;

    @Override
    public TheaterResponse addTheater(String email, TheaterRequest theaterRequest) {
        Optional<UserDetails> optionalUserDetails = userRepository.findByEmail(email);
        if (optionalUserDetails.isEmpty()) {
            throw new UserNotFoundByEmailException("User not found with email: " + email);
        }

        UserDetails userDetails = optionalUserDetails.get();
        if (userDetails.getUserRoles() != UserRoles.THEATER_OWNER) {
            throw new UserNotFoundByEmailException("This user is not a theater owner");
        }

        TheaterOwner theaterOwner = (TheaterOwner) userDetails;

        Theater newTheater = new Theater();
        newTheater.setName(theaterRequest.name());
        newTheater.setAddress(theaterRequest.address());
        newTheater.setCity(theaterRequest.city());
        newTheater.setLandmark(theaterRequest.landmark());
       // newTheater.setCreatedAt(System.currentTimeMillis());
        newTheater.setOwner(theaterOwner);

        theaterRepository.save(newTheater);

        return new TheaterResponse(
                newTheater.getName(),
                newTheater.getAddress(),
                newTheater.getCity(),
                newTheater.getLandmark()
        );
    }




    @Override
    public TheaterResponse findTheater(String id) {
        Theater theater = theaterRepository.findById(id)
                .orElseThrow(() -> new TheaterOwnerIdException("Theater not found with id: " + id));

        return new TheaterResponse(
                theater.getName(),
                theater.getAddress(),
                theater.getCity(),
                theater.getLandmark()
        );
    }

    @Override
    public TheaterResponse updateTheater(String id, TheaterRequest updatedtheater) {
        // Fetch the theater by ID
        Theater existingTheater = theaterRepository.findById(id)
                .orElseThrow(() -> new TheaterOwnerIdException("Theater not found with the provided ID!"));

        // Update theater fields with the provided data
        existingTheater.setName(updatedtheater.name());
        existingTheater.setAddress(updatedtheater.address());
        existingTheater.setCity(updatedtheater.city());
        existingTheater.setLandmark(updatedtheater.landmark());
        existingTheater.setUpdatedAt(Instant.ofEpochMilli(System.currentTimeMillis()));

        // Save the updated theater back to the repository
        theaterRepository.save(existingTheater);

        // Return success message
        return new TheaterResponse(
                existingTheater.getName(),
                existingTheater.getAddress(),
                existingTheater.getCity(),
                existingTheater.getLandmark()

        );
    }
    }



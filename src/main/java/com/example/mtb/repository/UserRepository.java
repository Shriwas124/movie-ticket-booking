package com.example.mtb.repository;

import com.example.mtb.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDetails,String> {

    boolean existsByEmail(String email);

    Optional<UserDetails> findByEmail(String email);
}

package com.example.mtb.repository;

import com.example.mtb.entity.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScreenRepository extends JpaRepository<Screen,String> {


}

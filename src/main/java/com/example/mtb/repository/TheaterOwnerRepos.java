package com.example.mtb.repository;

import com.example.mtb.entity.Theater;
import com.example.mtb.entity.TheaterOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterOwnerRepos extends JpaRepository<TheaterOwner,String> {

}

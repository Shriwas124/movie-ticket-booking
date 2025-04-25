package com.example.mtb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Table(name = "theater_owner")
@NoArgsConstructor
@Setter
@Getter
@Entity
public class TheaterOwner extends UserDetails {



    @OneToMany(mappedBy = "theaterOwner")
    private List<Theater> theaters;

}

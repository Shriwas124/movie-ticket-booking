package com.example.mtb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Table(name = "theater_owner")
@Setter
@Getter
@Entity
public class TheaterOwner extends UserDetails {




    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Theater> theaters = new ArrayList<>();

}

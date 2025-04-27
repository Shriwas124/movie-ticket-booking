package com.example.mtb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private String seatId;
    private String seatName;
    private Long createdAt;


    @ManyToOne
    private Screen screen;
}

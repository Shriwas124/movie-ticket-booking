package com.example.mtb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Seat {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private String seatId;
    private String seatName;
    @Column(name = "created_At", nullable = false, updatable = false)
    @CreatedDate
    private Instant createdAt;


    @ManyToOne
    private Screen screen;
}

package com.example.mtb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@ToString
@Entity
public class Theater {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String theaterId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String landmark;

    @ManyToOne
    private TheaterOwner theaterOwner;

    private long createdAt;
    @LastModifiedDate
    private long updatedAt;
    private String createdBy;


}



















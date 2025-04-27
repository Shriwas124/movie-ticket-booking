package com.example.mtb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.List;

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
    private long createdAt;
    private long updatedAt;
    private String createdBy;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theater_owner_id", nullable = false)
    private TheaterOwner owner;

    @OneToMany(mappedBy = "theater")
    private List<Screen> screen;
}



















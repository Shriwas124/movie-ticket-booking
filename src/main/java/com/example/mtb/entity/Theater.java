package com.example.mtb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@ToString
@Entity
@EntityListeners(AuditingEntityListener.class)
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
    @Column(name = "created_At", nullable = false, updatable = false)
    @CreatedDate
    private Instant createdAt;
    @Column(name = "updated_At", nullable = false)
    @LastModifiedDate
    private Instant updatedAt;
    @Column(name = "created_By", nullable = false, updatable = false)
    @CreatedBy
    private String createdBy;
    @Column(name = "updated_By", nullable = false)
    @LastModifiedBy
    private String updatedBy;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theater_owner_id", nullable = false)
    private TheaterOwner owner;

    @OneToMany(mappedBy = "theater")
    private List<Screen> screen;
}



















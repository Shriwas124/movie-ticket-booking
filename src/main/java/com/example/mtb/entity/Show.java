package com.example.mtb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Show {
    @Id
    private  String showId;
    private Instant startsAt;
    private Instant endsAt;
    @Column(name = "created_At", nullable = false, updatable = false)
    @CreatedDate
    private Instant createdAt;
    @Column(name = "updated_At", nullable = false)
    @LastModifiedDate
    private Instant updatedAt;
    @Column(name = "created_By", nullable = false, updatable = false)
    @CreatedBy
    private String createdBy;
}

package com.example.mtb.entity;

import com.example.mtb.enums.UserRoles;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@ToString
@Entity
@EntityListeners(AuditingEntityListener.class)
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;

    private String username;
    private String email;
    private String password;

    private String phoneNumber;

    @Enumerated(value = EnumType.STRING)
    private UserRoles userRoles;
    private LocalDate dateofbirth;

    @Column(name = "created_At", nullable = false, updatable = false)
    @CreatedDate
    private Instant createdAt;
    @Column(name = "updated_At", nullable = false)
    @LastModifiedDate
    private Instant updatedAt;


    @Column(name = "is_deleted", nullable = false, columnDefinition = "boolean default false")
    private boolean isDeleted = false;
    @Column(name = "deleted_at", nullable = true)
    private Instant deletedAt;





}

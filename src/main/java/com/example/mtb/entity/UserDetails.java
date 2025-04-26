package com.example.mtb.entity;

import com.example.mtb.enums.UserRoles;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@ToString
@Entity
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
    private long createdAt;
    private long updatedAt;


    @Column(name = "is_deleted")
    private boolean isDeleted = false;
    @Column(name = "deleted_at")
    private Instant deletedAt;


    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt != null ? createdAt.atZone(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli() : null;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt != null ? updatedAt.atZone(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli() : null;
    }


}

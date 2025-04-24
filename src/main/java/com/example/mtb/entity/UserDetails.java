package com.example.mtb.entity;

import com.example.mtb.enums.UserRoles;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;
import static com.example.mtb.enums.UserRoles.THEATER_OWNER;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class UserDetails  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;
    private  String username;
    private  String email;
    private String password;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @NotNull
    private UserRoles userRoles;
    private LocalDate dateofbirth;
    private  long createdAt;
    private long updatedAt;
    @Column(name="is_deleted")
    private boolean isDeleted=false;
    @Column(name ="deleted_at")
    private Instant deleteAt;

    public void softDelete(){

        this.isDeleted=true;
        this.deleteAt=Instant.now();
    }

}

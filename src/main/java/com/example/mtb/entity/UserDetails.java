package com.example.mtb.entity;

import com.example.mtb.enums.UserRoles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class UserDetails  {
    @Id
    private String userId;
    private  String username;
    private  String emails;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRoles userRole;
    private LocalDate dateofBirth;
    private  long createdAt;
    private long updatedAt;

}

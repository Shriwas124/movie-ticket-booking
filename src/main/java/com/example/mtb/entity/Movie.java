package com.example.mtb.entity;


import com.example.mtb.enums.Certificate;
import com.example.mtb.enums.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Duration;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String movieId;
    private String title;
    private String description;
    @ElementCollection
    private Set<String> castlist;
    private Duration runtime;

    @Enumerated(value = EnumType.STRING)
    private Certificate certificate;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
    private List<Feedback> feedbackList;
}

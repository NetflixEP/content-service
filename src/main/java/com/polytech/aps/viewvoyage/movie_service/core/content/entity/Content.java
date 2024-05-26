package com.polytech.aps.viewvoyage.movie_service.core.content.entity;

import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.content.AgeRestriction;
import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.content.Category;
import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.content.Genre;
import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.content.Quality;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Content {
    @Id
    @UuidGenerator
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Quality quality;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "age_restriction", nullable = false)
    @Enumerated(EnumType.STRING)
    private AgeRestriction ageRestriction;

    private String description;
    private String thumbnail;
    private String publisher;

    @Column(name = "created_date", nullable = false)
    private LocalDate createdDate;

    @Column(name = "remaining_time")
    private LocalDateTime remainingTime;
}

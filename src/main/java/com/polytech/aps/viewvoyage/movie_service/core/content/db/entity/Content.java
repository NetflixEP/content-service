package com.polytech.aps.viewvoyage.movie_service.core.content.db.entity;

import com.polytech.aps.viewvoyage.movie_service.core.content.db.converter.AgeRestrictionConverter;
import com.polytech.aps.viewvoyage.movie_service.core.content.db.converter.QualityConverter;
import com.polytech.aps.viewvoyage.movie_service.core.episode.db.entity.Episode;
import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.content.AgeRestriction;
import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.content.Category;
import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.content.Genre;
import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.content.Quality;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
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
    @Convert(converter = QualityConverter.class)
    private Quality quality;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "age_restriction", nullable = false)
    @Convert(converter = AgeRestrictionConverter.class)
    private AgeRestriction ageRestriction;

    private String description;

    private String thumbnail;

    private String publisher;

    @Column(name = "created_date", nullable = false)
    private LocalDate createdDate;

    @Column(name = "remaining_time")
    private LocalDateTime remainingTime;

    @OneToMany(mappedBy = "content", fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Episode> episodes;

    @OneToMany(mappedBy = "content", fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<CastMember> castMembers;
}

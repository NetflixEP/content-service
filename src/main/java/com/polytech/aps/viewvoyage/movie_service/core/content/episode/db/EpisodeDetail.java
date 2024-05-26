package com.polytech.aps.viewvoyage.movie_service.core.content.episode.db;

import com.polytech.aps.viewvoyage.movie_service.core.content.entity.Content;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "episode_detail")
public class EpisodeDetail {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private String title;

    private String thumbnail;
    private String storyline;

    @JoinColumn(name = "content_id", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Content.class, fetch = FetchType.LAZY)
    private Content content;

    @Column(name = "content_id", nullable = false)
    private UUID contentId;

    @Column(name = "season_num", nullable = false)
    private Integer seasonNumber;
}

package com.polytech.aps.viewvoyage.movie_service.core.episode.db.entity;

import com.polytech.aps.viewvoyage.movie_service.core.content.db.entity.Content;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Episode {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private String title;

    private String thumbnail;

    private String storyline;

    @Column(name = "s3_bucket_name", nullable = false)
    private String s3BucketName;

    @Column(name = "episode_num", nullable = false)
    private Integer episodeNumber;

    @Column(name = "season_num", nullable = false)
    private Integer seasonNumber;

    @JoinColumn(name = "content_id", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Content.class, fetch = FetchType.LAZY)
    private Content content;

    @Column(name = "content_id", nullable = false)
    private UUID contentId;
}

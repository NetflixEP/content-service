package com.polytech.aps.viewvoyage.movie_service.core.content.episode.db;

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
public class Episode {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @JoinColumn(name = "episode_detail_id", insertable = false, updatable = false)
    @ManyToOne(targetEntity = EpisodeDetail.class, fetch = FetchType.LAZY)
    private EpisodeDetail episodeDetail;

    @Column(name = "episode_detail_id", nullable = false)
    private UUID episodeDetailId;

    @Column(name = "s3_bucket_name", nullable = false)
    private String s3BucketName;
}

package com.polytech.aps.viewvoyage.movie_service.core.episode.db;

import com.polytech.aps.viewvoyage.movie_service.core.episode.db.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EpisodeRepository extends JpaRepository<Episode, UUID> {
}

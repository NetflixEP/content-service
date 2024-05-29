package com.polytech.aps.viewvoyage.movie_service.core.content.db;

import com.polytech.aps.viewvoyage.movie_service.core.content.db.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContentRepository extends JpaRepository<Content, UUID> {

}

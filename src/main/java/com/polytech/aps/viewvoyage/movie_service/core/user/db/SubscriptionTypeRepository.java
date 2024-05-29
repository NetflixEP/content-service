package com.polytech.aps.viewvoyage.movie_service.core.user.db;

import com.polytech.aps.viewvoyage.movie_service.core.user.db.entity.SubscriptionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionTypeRepository extends JpaRepository<SubscriptionType, String> {
}

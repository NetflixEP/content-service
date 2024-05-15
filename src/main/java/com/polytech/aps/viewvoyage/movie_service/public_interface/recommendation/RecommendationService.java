package com.polytech.aps.viewvoyage.movie_service.public_interface.recommendation;

import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.recommendations.ContentRecommendationDto;

import java.util.List;
import java.util.UUID;

public interface RecommendationService {
    /**
     * Получение персональных рекомендаций для пользователей
     * @return список рекомендуемых фильмов к просмотру
     */
    List<ContentRecommendationDto> getPersonalRecommendations(UUID userId);
}

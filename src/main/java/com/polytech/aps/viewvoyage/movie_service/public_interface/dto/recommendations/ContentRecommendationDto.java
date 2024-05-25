package com.polytech.aps.viewvoyage.movie_service.public_interface.dto.recommendations;

import lombok.Builder;

@Builder
public record ContentRecommendationDto (
    Genre genre,
    Category category,
    short ageRestriction,
    String publisher,
    String title
) {
}

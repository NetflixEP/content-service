package com.polytech.aps.viewvoyage.movie_service.core.recommendation;

import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.content.Category;
import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.recommendations.ContentRecommendationDto;
import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.content.Genre;
import com.polytech.aps.viewvoyage.movie_service.public_interface.recommendation.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {
    @Override
    public List<ContentRecommendationDto> getPersonalRecommendations(UUID userId) {
        return List.of(
                new ContentRecommendationDto(
                        Genre.ACTION_FILM,
                        Category.MOVIE,
                        (short) 18,
                        "Summit Entertainment Thunder Road Pictures 87North Productions",
                        "John Wick"
                ),
                new ContentRecommendationDto(
                        Genre.CARTOON,
                        Category.ANIMATED_SERIES,
                        (short) 18,
                        "Starburns Industries",
                        "Rick and Morty"
                ),
                new ContentRecommendationDto(
                        Genre.THRILLER,
                        Category.SERIES,
                        (short) 18,
                        "Sony Pictures Television",
                        "Breaking Bad"
                ),
                new ContentRecommendationDto(
                        Genre.DRAMA,
                        Category.MOVIE,
                        (short) 18,
                        "Pandemonium Films",
                        "Hacksaw Ridge"
                ),
                new ContentRecommendationDto(
                        Genre.DRAMA,
                        Category.SERIES,
                        (short) 18,
                        "Untitled Korsh Company Hypnotic Films",
                        "Suits"
                )
        );
    }
}

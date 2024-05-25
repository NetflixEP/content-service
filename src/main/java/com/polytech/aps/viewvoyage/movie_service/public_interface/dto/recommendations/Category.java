package com.polytech.aps.viewvoyage.movie_service.public_interface.dto.recommendations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    MOVIE("Фильм"),
    SERIES("Сериал"),
    ANIMATED_FILM("Анимационный фильм"),
    ANIMATED_SERIES("Анимационный сериал");

    private final String name;
}

package com.polytech.aps.viewvoyage.movie_service.public_interface.dto.recommendations;

import lombok.Getter;

@Getter
public enum Category {
    MOVIE("Фильм"),
    SERIES("Сериал"),
    ANIMATED_FILM("Анимационный фильм"),
    ANIMATED_SERIES("Анимационный сериал");

    private final String name;

    Category(String name) {
        this.name = name;
    }
}

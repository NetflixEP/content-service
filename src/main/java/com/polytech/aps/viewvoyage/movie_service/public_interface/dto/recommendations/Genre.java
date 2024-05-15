package com.polytech.aps.viewvoyage.movie_service.public_interface.dto.recommendations;

import lombok.Getter;

@Getter
public enum Genre {
    ACTION_FILM("Боевик"),
    BLOCKBUSTER("Блокбастер"),
    CARTOON("Мультфильм"),
    COMEDY("Комедия"),
    DOCUMENTARY("Документальный фильм"),
    HISTORICAL_FILM("Исторический фильм"),
    HORROR_FILM("Ужастик"),
    MUSICAL("Мюзикл"),
    DRAMA("Драма"),
    THRILLER("Триллер");

    private final String name;

    Genre(String name) {
        this.name = name;
    }
}

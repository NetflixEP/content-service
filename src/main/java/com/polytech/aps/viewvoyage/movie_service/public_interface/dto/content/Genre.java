package com.polytech.aps.viewvoyage.movie_service.public_interface.dto.content;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
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
}

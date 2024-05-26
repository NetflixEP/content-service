package com.polytech.aps.viewvoyage.movie_service.public_interface.dto.content;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AgeRestriction {
    SIX_PLUS("6+"),
    TWELVE_PLUS("12+"),
    SIXTEEN_PLUS("16+"),
    EIGHTEEN_PLUS("18+");

    private final String restriction;
}

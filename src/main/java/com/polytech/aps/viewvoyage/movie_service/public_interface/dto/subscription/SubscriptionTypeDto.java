package com.polytech.aps.viewvoyage.movie_service.public_interface.dto.subscription;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record SubscriptionTypeDto(
        String code,
        String description,
        BigDecimal price) {
}

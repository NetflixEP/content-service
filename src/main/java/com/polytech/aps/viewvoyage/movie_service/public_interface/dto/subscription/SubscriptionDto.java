package com.polytech.aps.viewvoyage.movie_service.public_interface.dto.subscription;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record SubscriptionDto(
        boolean status,
        @JsonProperty("start_date") LocalDateTime startDate,
        @JsonProperty("end_date") LocalDateTime endDate,
        @JsonProperty("subscription_type") String subscriptionType
        ) {
}

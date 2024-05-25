package com.polytech.aps.viewvoyage.movie_service.public_interface.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.subscription.SubscriptionDto;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record UserDto(
        @JsonProperty(value = "first_name") String firstName,
        @JsonProperty(value = "last_name") String lastName,
        String email,
        String phone,
        LocalDate birthday,
        @JsonProperty(value = "subscription") SubscriptionDto subscription,
        @JsonProperty(value = "created_date") LocalDateTime createdDate
        ) {
}

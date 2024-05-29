package com.polytech.aps.viewvoyage.movie_service.public_interface.dto.subscription;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.math.BigDecimal;

/**
 * Сущность для вывода информации о подписках
 * @param code Тип подписки
 * @param description Описание преимуществ
 * @param price Цена подписки
 */
@Builder
@Schema(description = "Сущность для вывода информации о подписки пользователя")
public record SubscriptionTypeDto(
        @Schema(
                description = "Тип подписки",
                example = "PRO"
        )
        String code,
        @Schema(
                description = "Описание преимуществ",
                example = "Данная подписка включает бесплатную пиццу," +
                        "которая приедет в течении 30 минут" +
                        "после офромления подписки данного типа"
        )
        String description,
        @Schema(
                description = "Цена подписки",
                example = "3000"
        )
        BigDecimal price
) {
}

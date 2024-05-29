package com.polytech.aps.viewvoyage.movie_service.public_interface.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Сущность для пользователя нашего сервиса
 * @param firstName Имя пользователя
 * @param lastName Фамилия пользователя
 * @param login Логин пользователя
 * @param email Электронная почта пользователя
 * @param phone Номер телефона пользователя
 * @param birthday День рождения пользователя
 * @param subscription Тип подписки пользователя
 * @param createdDate Дана регистрации в сервисе
 * @param status Статус подпискм
 * @param startDate Дата начала подписки
 * @param endDate Дата конца подписки
 */
@Builder
@Schema(
        description = "",
        example = ""
)
public record UserDto(
        @Schema(
                description = "Имя пользователя",
                example = "Эрдем"
        )
        @JsonProperty(value = "first_name")
        String firstName,
        @Schema(
                description = "Фамилия пользователя",
                example = "Истаев"
        )
        @JsonProperty(value = "last_name")
        String lastName,
        @Schema(
                description = "Логин пользователя",
                example = "Greed"
        )
        String login,
        @Schema(
                description = "Электронная почта пользователя",
                example = "greed2003@mail.ru"
        )
        String email,
        @Schema(
                description = "Номер телефона пользователя",
                example = "89219324553"
        )
        String phone,
        @Schema(
                description = "День рождения пользователя",
                example = "2003-04-04"
        )
        LocalDate birthday,
        @Schema(
                description = "Тип подписки пользователя",
                example = "VIP"
        )
        @JsonProperty(value = "subscription")
        String subscription,
        @Schema(
                description = "Дана регистрации в сервисе",
                example = "2015-02-03 10:08:02"
        )
        @JsonProperty(value = "created_date")
        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
        LocalDateTime createdDate,
        @Schema(
                description = "Статус подпискм",
                example = "true"
        )
        @JsonProperty(value = "subscription_status")
        Boolean status,
        @Schema(
                description = "Дата начала подписки",
                example = "2019-02-03 10:08:02"
        )
        @JsonProperty(value = "subscription_start_date")
        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
        LocalDateTime startDate,
        @Schema(
                description = "Дата конца подписки",
                example = "2029-02-03 10:08:02"
        )
        @JsonProperty(value = "subscription_end_date")
        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
        LocalDateTime endDate
) {

}

package com.polytech.aps.viewvoyage.movie_service.public_interface.dto.comment;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDateTime;

/**
 * Сущность для пользовательских комментариев
 *
 * @param username Имя пользователя
 * @param text Текст комментария полльзователя
 * @param createdAt Дата созадния комментария
 */
@Builder
@Schema(description = "Сущность для пользовательских комментариев")
public record CommentDto (
        @Schema(
                description = "Имя пользователя",
                example = "Истаев Эрдем"
        )
        String username,
        @Schema(
                description = "Текст комментария полльзователя",
                example = "Шедевр"
        )
        String text,
        @Schema(
                description = "Дата созадния комментария",
                example = "2019-02-03 10:08:02"
        )
        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
        LocalDateTime createdAt
) {
}

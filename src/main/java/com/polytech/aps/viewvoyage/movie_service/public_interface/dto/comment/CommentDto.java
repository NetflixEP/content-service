package com.polytech.aps.viewvoyage.movie_service.public_interface.dto.comment;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CommentDto (
        String username,
        String text,
        LocalDateTime createdAt
) {
}

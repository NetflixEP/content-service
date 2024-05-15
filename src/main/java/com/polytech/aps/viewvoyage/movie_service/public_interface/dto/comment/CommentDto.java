package com.polytech.aps.viewvoyage.movie_service.public_interface.dto.comment;

import java.time.LocalDateTime;

public record CommentDto (
        String username,
        String text,
        LocalDateTime createdAt
) {
}

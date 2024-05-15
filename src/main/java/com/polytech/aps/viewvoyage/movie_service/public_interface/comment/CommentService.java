package com.polytech.aps.viewvoyage.movie_service.public_interface.comment;

import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.comment.CommentDto;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    List<CommentDto> getContentComments(UUID contentId);

    CommentDto addCommentToContent(UUID contentId, CommentDto commentDto);
}

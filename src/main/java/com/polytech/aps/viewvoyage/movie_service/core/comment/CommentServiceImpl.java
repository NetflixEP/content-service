package com.polytech.aps.viewvoyage.movie_service.core.comment;

import com.polytech.aps.viewvoyage.movie_service.public_interface.comment.CommentService;
import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.comment.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    public List<CommentDto> getContentComments(UUID contentId) {
        return List.of(
                new CommentDto(
                        "Greed",
                        "Плакал весь фильм",
                        LocalDateTime.now()),
                new CommentDto(
                        "User1",
                        "Никогда больше не пойду на этот фильм",
                        LocalDateTime.now()),
                new CommentDto(
                        "User3",
                        "Люблю такие фильмы",
                        LocalDateTime.now())
        );
    }

    @Override
    public CommentDto addCommentToContent(UUID contentId, CommentDto commentDto) {
        return commentDto;
    }
}

package com.polytech.aps.viewvoyage.movie_service.rest.movie;

import com.polytech.aps.viewvoyage.movie_service.public_interface.comment.CommentService;
import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.comment.CommentDto;
import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.recommendations.ContentRecommendationDto;
import com.polytech.aps.viewvoyage.movie_service.public_interface.recommendation.RecommendationService;
import com.polytech.aps.viewvoyage.movie_service.public_interface.search.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/v0/contents")
public class ContentController {
    private final RecommendationService recommendationService;
    private final CommentService commentService;
    private final SearchService searchService;

    @GetMapping("/recommendations/{user_id}")
    public List<ContentRecommendationDto> getPersonalRecommendations(@PathVariable(value = "user_id") UUID userId) {
        return recommendationService.getPersonalRecommendations(userId);
    }

    @GetMapping("/{content_id}/comments")
    public List<CommentDto> getComments(@PathVariable(value = "content_id") UUID contentId) {
        return commentService.getContentComments(contentId);
    }

    @PostMapping("/{content_id}/comments")
    public CommentDto addComment(
            @PathVariable(value = "content_id") UUID contentId,
            @RequestBody CommentDto commentDto
    ) {
        return commentService.addCommentToContent(contentId, commentDto);
    }

    public static void main(String[] args) {
        String a = "aaa, aaa, fff";
        System.out.println(Character.isDigit('5'));
    }
}

package com.polytech.aps.viewvoyage.movie_service.rest.content;

import com.polytech.aps.viewvoyage.movie_service.public_interface.comment.CommentService;
import com.polytech.aps.viewvoyage.movie_service.public_interface.content.ContentService;
import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.comment.CommentDto;
import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.content.ContentDto;
import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.recommendations.ContentRecommendationDto;
import com.polytech.aps.viewvoyage.movie_service.public_interface.recommendation.RecommendationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/contents")
@Tag(
        name = "Контроллер для фильмов и сериалов",
        description = "Контроллер для манипулирования основаными данными, связанными с фильмами и сериалами")
public class ContentController {
    private final RecommendationService recommendationService;
    private final CommentService commentService;
    private final ContentService contentService;

    @GetMapping("/recommendations/{user-id}")
    @Operation(
            summary = "Получение персональных рекомендаций",
            description = "Позволяет получить персональные рекомендации по фильмам и сериалам, которые однозначно подойдут данному пользователю"
    )
    public List<ContentRecommendationDto> getPersonalRecommendations(
            @PathVariable(value = "user-id")
            @Parameter(description = "ID пользователя, для которого будут подбираться рекомендации", example = "f7d1b2c1-cedb-4099-99d8-e4ec9302dcde")
            UUID userId) {
        return recommendationService.getPersonalRecommendations(userId);
    }

    @GetMapping("/{content-id}/comments")
    @Operation(
            summary = "Получение комментариев под фильмом или сериалом",
            description = "Позволяет получить комментарии, оставленными всеми пользователями под данным фильмом или сериалом"
    )
    public List<CommentDto> getComments(
            @Parameter(description = "ID фильма или сериала", example = "1b12236a-aca9-47bc-95ac-f3978836de2c")
            @PathVariable(value = "content-id")
            UUID contentId) {
        return commentService.getContentComments(contentId);
    }

    @PostMapping("/{content-id}/comments")
    @Operation(
            summary = "Добавить свой комментарий под фильмом или сериалом",
            description = "Позволяет добавлять комментарии под фильм или сериал"
    )
    public CommentDto addComment(
            @Parameter(description = "ID фильма или сериала", example = "1b12236a-aca9-47bc-95ac-f3978836de2c")
            @PathVariable(value = "content-id")
            UUID contentId,
            @Parameter(description = "Сущность для манипулирования комментариями")
            @RequestBody
            CommentDto commentDto
    ) {
        return commentService.addCommentToContent(contentId, commentDto);
    }

    @GetMapping
    @Operation(
            summary = "Получение фильмов или сериалов",
            description = "Позволяет получить несколько фильмов или сериалов для последующей загрузке на начальной странице с фильмами"
    )
    public List<ContentDto> getAllContent(
            @Parameter(description = "Параметр номера страницы", example = "0")
            @RequestParam(value = "page_number")
            int pageNumber,
            @Parameter(description = "Параметр количества отображаемых фильмов и сериалов на странице", example = "3")
            @RequestParam(value = "page_size")
            int pageSize) {
        return contentService.findAllContent(PageRequest.of(pageNumber, pageSize));
    }

    @PutMapping("/{content-id}")
    @Operation(
            summary = "Обновление информации о фильме или сериале",
            description = "Позволяет обновить главную информацию, связанную с фильмом или сериалом"
    )
    public void updateContentInfo(
            @Parameter(description = "ID фильма или сериала", example = "1b12236a-aca9-47bc-95ac-f3978836de2c")
            @PathVariable(value = "content-id")
            UUID contentId,
            @Parameter(description = "Сущность для манипулирования информацией по фильмам и сериалам")
            @RequestBody
            ContentDto contentDto) {
        contentService.updateContent(contentId, contentDto);
    }

    @PostMapping
    @Operation(
            summary = "Создание нового фильма или сериала",
            description = "Позволяет добавить информацию о фильме или сериале в сервис, чтобы другие люди смогли насладиться контентом за денежки"
    )
    public ContentDto createContent(
            @Parameter(description = "Сущность для манипулирования информацией по фильмам и сериалам")
            @RequestBody
            ContentDto contentDto) {
        return contentService.createContent(contentDto);
    }
}

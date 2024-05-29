package com.polytech.aps.viewvoyage.movie_service.rest.episode;

import com.polytech.aps.viewvoyage.movie_service.public_interface.content.ContentService;
import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.episode.EpisodeDto;
import com.polytech.aps.viewvoyage.movie_service.public_interface.episode.EpisodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/episodes")
@Tag(
        name = "Контролер эпизодов",
        description = "Позволяет манипулировать данными эпизодов")
public class EpisodeController {
    private final EpisodeService episodeService;
    private final ContentService contentService;

    @GetMapping("/{episode-id}")
    @Operation(
            summary = "Получить информацию о эпизоде",
            description = "Предоставляет полную информацию о эпизоде с заданным id")
    public EpisodeDto getEpisodeById(
            @Parameter(description = "ID эпизода", example = "d27ca94d-4206-45fe-b8c4-486403544d64")
            @PathVariable("episode-id")
            UUID episodeId) {
        return episodeService.getEpisodeById(episodeId);
    }

    @PutMapping("/{episode-id}")
    @Operation(
            summary = "Обновление информации о эпизоде",
            description = "Обновляем информацию существующего эпизода с заданным id с помощью данных из тела запроса")
    public void updateEpisodeById(
            @Parameter(description = "ID эпизода", example = "d27ca94d-4206-45fe-b8c4-486403544d64")
            @PathVariable("episode-id")
            UUID episodeId,
            @RequestBody
            @Parameter(description = "Тело запроса для обновления существующего эпизода")
            EpisodeDto episodeDto) {
        episodeService.updateEpisodeInfo(episodeId, episodeDto);
    }

    @PostMapping("/{content-id}")
    @Operation(
            summary = "Создание нового эпизода",
            description = "Создаём новый эпизод для заданного контента с помощью данных из тела запроса")
    public EpisodeDto createEpisodeForContent(
            @Parameter(description = "ID фильма или сериала", example = "1b12236a-aca9-47bc-95ac-f3978836de2c")
            @PathVariable("content-id")
            UUID contentId,
            @Parameter(description = "Тело запроса для создания нового эпизода")
            @RequestBody
            EpisodeDto episodeDto) {
        return episodeService.createNewEpisode(contentId, episodeDto);
    }

    @GetMapping
    @Operation(
            summary = "Получение всех эпизодоа, связанных с контентом",
            description = "Получаем все эпизоды, связанные с заданным контентом")
    public Set<EpisodeDto> getAllEpisodesForContent(
            @Parameter(description = "ID фильма или сериала", example = "1b12236a-aca9-47bc-95ac-f3978836de2c")
            @RequestParam(value = "content_id")
            UUID contentId) {
        return contentService.findAllEpisodesForContent(contentId);
    }
}

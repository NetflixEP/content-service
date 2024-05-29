package com.polytech.aps.viewvoyage.movie_service.public_interface.dto.recommendations;

import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.content.Category;
import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.content.Genre;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

/**
 * Сущность для рекомендуемых фильмов
 * @param genre Жанр воспроизводимового видео
 * @param category Категория контента
 * @param ageRestriction Возрастные ограничения для просмотра
 * @param publisher Издатель произведения
 * @param title Название видео
 */
@Builder
@Schema(description = "Сущность для рекомендуемых фильмов")
public record ContentRecommendationDto (
        @Schema(
                description = "Жанр воспроизводимового видео",
                example = "ACTION_FILM"
        )
        Genre genre,
        @Schema(
                description = "Категория контента",
                example = "ANIMATED_SERIES")
        Category category,
        @Schema(
                description = "Возрастные ограничения для просмотра",
                example = "6"
        )
        Short ageRestriction,
        @Schema(
                description = "Издатель произведения",
                example = "Netflix"
        )
        String publisher,
        @Schema(
                description = "Название видео",
                example = "Баки Ханма"
        )
        String title
) {
}


//
///**
// * Сущность для манипулирования основаными данными фильмов и сериалов
// * @param id Идентификатор сущности контента
// * @param title Название видео
// * @param quality Качество видео
// * @param genre Жанр воспроизводимового видео
// * @param category Категория контента
// * @param ageRestriction Возрастные ограничения для просмотра
// * @param description Описания фильма или сериала
// * @param thumbnail Картинка на заставке к видео
// * @param publisher Издатель произведения
// * @param createdDate Дата создания произведения
// * @param remainingTime Забыл, надеюсь вспомню
// * @param castMembers Люди, принимавшие участие в съёмке данного произведения
// */
//@Builder
//@Schema(description = "Сущность для манипулирования основаными данными фильмов и сериалов")
//public record ContentDto (
//        @Schema(description = "Идентификатор сущности контента", example = "1b12236a-aca9-47bc-95ac-f3978836de2c")
//        UUID id,
//        @Schema(description = "Название видео", example = "Баки Ханма")
//        String title,
//        @Schema(description = "Качество видео", example = "P1080")
//        Quality quality,
//        @Schema(description = "Жанр воспроизводимового видео", example = "ACTION_FILM")
//        Genre genre,

//        @Schema(description = "Возрастные ограничения для просмотра", example = "EIGHTEEN_PLUS")
//        @JsonProperty(value = "age_restriction")
//        AgeRestriction ageRestriction,
//        @Schema(
//                description = "Описания фильма или сериала",
//                example = "Баки Ханма интенсивно тренируется,чтобы превзойти отца, " +
//                        "который считается сильнейшим бойцом в мире. " +
//                        "В это же время пятеро самых жестоких заключенных-смертников совершают побег. " +
//                        "Ими движет только одна цель — сразиться с Баки и победить.")
//        String description,
//        @Schema(description = "Картинка на заставке к видео", example = "https://www.kinopoisk.ru/film/1125417/posters/")
//        String thumbnail,
//        @Schema(description = "Издатель произведения", example = "Netflix")
//        String publisher,
//        @JsonProperty(value = "created_date")
//        @JsonFormat(pattern="yyyy-MM-dd")
//        @Schema(description = "Дата создания произведения", example = "2018-06-06")
//        LocalDate createdDate,
//        @JsonProperty(value = "remaining_time")
//        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
//        @Schema(description = "Забыл, надеюсь вспомню", example = "2019-02-03 10:08:02")
//        LocalDateTime remainingTime,
//        @JsonProperty(value = "cast_members")
//        @Schema(description = "Люди, принимавшие участие в съёмке данного произведения")
//        Set<CastMemberDto> castMembers
//) {
//}
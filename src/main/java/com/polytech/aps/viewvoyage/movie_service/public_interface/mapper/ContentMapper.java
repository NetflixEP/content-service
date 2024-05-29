package com.polytech.aps.viewvoyage.movie_service.public_interface.mapper;

import com.polytech.aps.viewvoyage.movie_service.core.content.db.entity.CastMember;
import com.polytech.aps.viewvoyage.movie_service.core.content.db.entity.Content;
import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.content.CastMemberDto;
import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.content.ContentDto;
import org.springframework.data.domain.Page;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ContentMapper {
    public static ContentDto convertToContentDto(Content content) {
        return ContentDto.builder()
                .id(content.getId())
                .title(content.getTitle())
                .ageRestriction(content.getAgeRestriction())
                .genre(content.getGenre())
                .category(content.getCategory())
                .createdDate(content.getCreatedDate())
                .quality(content.getQuality())
                .description(content.getDescription())
                .publisher(content.getPublisher())
                .remainingTime(content.getRemainingTime())
                .thumbnail(content.getThumbnail())
                .castMembers(content.getCastMembers() == null ? Collections.emptySet() : convertToSetOfCastMemberDto(content.getCastMembers()))
                .build();
    }

    public static Content convertToContentEntity(ContentDto contentDto) {
        return Content.builder()
                .title(contentDto.title())
                .ageRestriction(contentDto.ageRestriction())
                .genre(contentDto.genre())
                .category(contentDto.category())
                .createdDate(contentDto.createdDate())
                .quality(contentDto.quality())
                .description(contentDto.description())
                .publisher(contentDto.publisher())
                .remainingTime(contentDto.remainingTime())
                .thumbnail(contentDto.thumbnail())
                .build();
    }

    public static List<ContentDto> convertToListOfContentDto(Page<Content> contents) {
        return contents.stream()
                .map(ContentMapper::convertToContentDto)
                .toList();
    }

    public static Content patchUpdate(Content oldEpisodeDetail, ContentDto contentDto) {
        return Content.builder()
                .title(contentDto.title() != null ? contentDto.title() : oldEpisodeDetail.getTitle())
                .ageRestriction(contentDto.ageRestriction() != null ? contentDto.ageRestriction() : oldEpisodeDetail.getAgeRestriction())
                .genre(contentDto.genre() != null ? contentDto.genre() : oldEpisodeDetail.getGenre())
                .category(contentDto.category() != null ? contentDto.category() : oldEpisodeDetail.getCategory())
                .createdDate(contentDto.createdDate() != null ? contentDto.createdDate() : oldEpisodeDetail.getCreatedDate())
                .quality(contentDto.quality() != null ? contentDto.quality() : oldEpisodeDetail.getQuality())
                .description(contentDto.description() != null ? contentDto.description() : oldEpisodeDetail.getDescription())
                .publisher(contentDto.publisher() != null ? contentDto.publisher() : oldEpisodeDetail.getPublisher())
                .remainingTime(contentDto.remainingTime() != null ? contentDto.remainingTime() : oldEpisodeDetail.getRemainingTime())
                .thumbnail(contentDto.thumbnail() != null ? contentDto.thumbnail() : oldEpisodeDetail.getThumbnail())
                .build();
    }


    private static Set<CastMemberDto> convertToSetOfCastMemberDto(Set<CastMember> contents) {
        return contents.stream()
                .map(CastMemberMapper::convertToCastMemberDto)
                .collect(Collectors.toSet());
    }

    private ContentMapper() {

    }
}

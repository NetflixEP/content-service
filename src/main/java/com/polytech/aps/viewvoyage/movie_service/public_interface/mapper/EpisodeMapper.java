package com.polytech.aps.viewvoyage.movie_service.public_interface.mapper;

import com.polytech.aps.viewvoyage.movie_service.core.episode.db.entity.Episode;
import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.episode.EpisodeDto;

import java.util.UUID;

public final class EpisodeMapper {
    public static EpisodeDto convertToEpisodeDto(Episode episode) {
        return EpisodeDto.builder()
                .id(episode.getId())
                .s3BucketName(episode.getS3BucketName())
                .episodeNumber(episode.getEpisodeNumber())
                .seasonNumber(episode.getSeasonNumber())
                .title(episode.getTitle())
                .thumbnail(episode.getThumbnail())
                .storyline(episode.getStoryline())
                .build();
    }

    public static Episode patchUpdate(Episode oldEpisode, EpisodeDto newDto) {
        return Episode.builder()
                .title(newDto.title() == null ? oldEpisode.getTitle() : newDto.title())
                .thumbnail(newDto.thumbnail()  == null ? oldEpisode.getThumbnail() : newDto.thumbnail())
                .storyline(newDto.storyline()  == null ? oldEpisode.getStoryline() : newDto.storyline())
                .seasonNumber(newDto.seasonNumber()  == null ? oldEpisode.getSeasonNumber() : newDto.seasonNumber())
                .episodeNumber(newDto.episodeNumber()  == null ? oldEpisode.getEpisodeNumber() : newDto.episodeNumber())
                .storyline(newDto.storyline() == null ? oldEpisode.getStoryline() : newDto.storyline())
                .s3BucketName(newDto.s3BucketName() == null ? oldEpisode.getS3BucketName() : newDto.s3BucketName())
                .build();
    }

    public static Episode convertToEpisodeEntity(EpisodeDto episodeDto, UUID contentId) {
        return Episode.builder()
                .s3BucketName(episodeDto.s3BucketName())
                .episodeNumber(episodeDto.episodeNumber())
                .seasonNumber(episodeDto.seasonNumber())
                .title(episodeDto.title())
                .thumbnail(episodeDto.thumbnail())
                .storyline(episodeDto.storyline())
                .contentId(contentId)
                .build();
    }

    private EpisodeMapper() {

    }
}

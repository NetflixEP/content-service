package com.polytech.aps.viewvoyage.movie_service.core.episode;

import com.polytech.aps.viewvoyage.movie_service.core.episode.db.EpisodeRepository;
import com.polytech.aps.viewvoyage.movie_service.core.episode.db.entity.Episode;
import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.episode.EpisodeDto;
import com.polytech.aps.viewvoyage.movie_service.public_interface.episode.EpisodeService;
import com.polytech.aps.viewvoyage.movie_service.public_interface.mapper.EpisodeMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EpisodeServiceImpl implements EpisodeService {
    private final EpisodeRepository episodeRepository;

    @Override
    public EpisodeDto createNewEpisode(UUID contentId, EpisodeDto episode) {
        return EpisodeMapper.convertToEpisodeDto(episodeRepository.save(EpisodeMapper.convertToEpisodeEntity(episode, contentId)));
    }

    @Override
    @Transactional
    public void updateEpisodeInfo(UUID episodeId, EpisodeDto episode) {
        Episode oldEpisode = episodeRepository.findById(episodeId)
                .orElseThrow(() -> new IllegalArgumentException("Episode not found"));

        Episode updatedEpisode = EpisodeMapper.patchUpdate(oldEpisode, episode);
        episodeRepository.save(updatedEpisode);
    }

    @Override
    public EpisodeDto getEpisodeById(UUID id) {
        return EpisodeMapper.convertToEpisodeDto(episodeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Episode not found")));
    }
}

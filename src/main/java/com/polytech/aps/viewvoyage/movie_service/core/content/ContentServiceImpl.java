package com.polytech.aps.viewvoyage.movie_service.core.content;

import com.polytech.aps.viewvoyage.movie_service.core.content.db.ContentRepository;
import com.polytech.aps.viewvoyage.movie_service.core.content.db.entity.Content;
import com.polytech.aps.viewvoyage.movie_service.public_interface.content.ContentService;
import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.content.ContentDto;
import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.episode.EpisodeDto;
import com.polytech.aps.viewvoyage.movie_service.public_interface.mapper.ContentMapper;
import com.polytech.aps.viewvoyage.movie_service.public_interface.mapper.EpisodeMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.polytech.aps.viewvoyage.movie_service.public_interface.mapper.ContentMapper.patchUpdate;

@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {
    private final ContentRepository contentRepository;

    @Override
    public ContentDto createContent(ContentDto contentDto) {
        return ContentMapper.convertToContentDto(contentRepository.save(ContentMapper.convertToContentEntity(contentDto)));
    }

    @Override
    @Transactional
    public void updateContent(UUID id, ContentDto contentDto) {
        Content oldContent = contentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Episode not found"));

        Content updatedContent = patchUpdate(oldContent, contentDto);

        contentRepository.save(updatedContent);
    }

    @Override
    public Set<EpisodeDto> findAllEpisodesForContent(UUID contentId) {
        Content curContent = contentRepository.findById(contentId)
                .orElseThrow(() -> new IllegalArgumentException("Episode not found"));
        return curContent.getEpisodes()
                .stream()
                .map(EpisodeMapper::convertToEpisodeDto)
                .collect(Collectors.toSet());
    }

    @Override
    public List<ContentDto> findAllContent(Pageable pageable) {
        return ContentMapper.convertToListOfContentDto(contentRepository.findAll(pageable));
    }
}

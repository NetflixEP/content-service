package com.polytech.aps.viewvoyage.movie_service.public_interface.episode;

import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.episode.EpisodeDto;

import java.util.UUID;

public interface EpisodeService {
    /**
     * Создание нового эпихода в бд
     * @param contentId Идентификатор загружаемого ролика с основной информацией
     * @param episode Сущность для сохранения в нашем сервисе, чтобы остальные смогли смотреть ролики
     * @return Загруженная информация о ролике
     */
    EpisodeDto createNewEpisode(UUID contentId, EpisodeDto episode);

    /**
     * Обновление информации о эпизоде
     * @param episodeId Идентификатор эпизода
     * @param episode Данные для обновления эпизода
     */
    void updateEpisodeInfo(UUID episodeId, EpisodeDto episode);

    /**
     * Получения информации о конкретном ролике
     * @param id Идентификатор эпизода
     * @return Информация, которая хранится в нашей системе
     */
    EpisodeDto getEpisodeById(UUID id);
}

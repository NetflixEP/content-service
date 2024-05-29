package com.polytech.aps.viewvoyage.movie_service.public_interface.comment;

import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.comment.CommentDto;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    /**
     * Получение комментариев, которые оставляют пользователи под роликами
     * @param contentId Идентификатор ролика
     * @return Все оставленные комментарии, в том числе негативные
     */
    List<CommentDto> getContentComments(UUID contentId);

    /**
     * Добавление комментариев под роликом
     * @param contentId Идентификатор ролика
     * @param commentDto Сущность оставленного комментария
     * @return Сохранённый комментарий
     */
    CommentDto addCommentToContent(UUID contentId, CommentDto commentDto);
}

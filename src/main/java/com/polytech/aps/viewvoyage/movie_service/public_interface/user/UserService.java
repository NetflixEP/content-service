package com.polytech.aps.viewvoyage.movie_service.public_interface.user;

import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.user.UserDto;

import java.util.UUID;

public interface UserService {
    UserDto getUserInformation(UUID id);

    void updateUserInformation(UUID userId, UserDto userDto);
}

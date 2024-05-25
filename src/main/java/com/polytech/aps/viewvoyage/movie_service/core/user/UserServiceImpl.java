package com.polytech.aps.viewvoyage.movie_service.core.user;

import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.user.UserDto;
import com.polytech.aps.viewvoyage.movie_service.public_interface.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Override
    public UserDto getUserInformation(UUID id) {
        return null;
    }

    @Override
    public void updateUserInformation(UUID userId, UserDto userDto) {

    }
}

package com.polytech.aps.viewvoyage.movie_service.rest.user;

import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.user.UserDto;
import com.polytech.aps.viewvoyage.movie_service.public_interface.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/v0/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{user-id}")
    public UserDto getUserById(@PathVariable("user-id") UUID userId) {
        return userService.getUserInformation(userId);
    }

    @PutMapping("/{user-id}")
    public void updateUserInfo(@PathVariable("user-id") UUID userId, @RequestBody UserDto userDto) {
        userService.updateUserInformation(userId, userDto);
    }
}

package me.assetaid.element.user.controller;

import lombok.RequiredArgsConstructor;
import me.assetaid.element.user.repository.UserRepository;
import me.assetaid.element.user.repository.entity.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @PostMapping("/users")
    public void userSave(@RequestBody UserEntity user) {
        userRepository.save(user);
    }

}


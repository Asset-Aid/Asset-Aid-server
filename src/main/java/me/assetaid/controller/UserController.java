package me.assetaid.controller;

import lombok.RequiredArgsConstructor;
import me.assetaid.entity.UserEntity;
import me.assetaid.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    @PostMapping("/users")
    public void userSave(@RequestBody UserEntity user){
        userRepository.save(user);
    }
}

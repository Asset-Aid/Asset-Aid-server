package me.assetaid.feature.auth.controller;

import me.assetaid.feature.auth.application.dto.LoginRequestDTO;
import me.assetaid.feature.auth.application.dto.RegisterRequestDTO;
import me.assetaid.feature.auth.application.dto.IdCheckRequestDTO;
import me.assetaid.feature.auth.application.dto.PasswordCheckRequestDTO;
import me.assetaid.feature.auth.response.LoginResponse;
import me.assetaid.feature.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 로그인 API
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return userService.login(loginRequestDTO);
    }

    // 회원 가입 API
    @PostMapping("/register")
    public void register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        userService.register(registerRequestDTO);
    }

    // 로그아웃 API (refresh token 처리)
    @GetMapping("/logout")
    public String logout(@RequestParam String token) {
        userService.logout(token);
        return "Logout successful";
    }

    // ID 중복 체크 API
    @PostMapping("/check/id")
    public String checkId(@RequestBody IdCheckRequestDTO idCheckRequestDTO) {
        userService.checkId(idCheckRequestDTO.getId());
        return "ID is available";  // ID가 사용 가능한 경우 메시지 반환
    }

    // 비밀번호 확인 API
    @PostMapping("/check/password")
    public String checkPassword(@RequestBody PasswordCheckRequestDTO passwordCheckRequestDTO) {
        userService.checkPassword(passwordCheckRequestDTO.getPassword());
        return "Password is correct";  // 비밀번호가 올바른 경우 메시지 반환
    }

    // 회원 탈퇴 API
    @PatchMapping("/leave")
    public String leave(@RequestBody String userId) {
        userService.leave(userId);  // 회원 탈퇴 처리
        return "User has been deleted successfully.";
    }
}



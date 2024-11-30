package me.assetaid.feature.mypage.controller;

import me.assetaid.feature.mypage.application.MyPageService;
import me.assetaid.feature.mypage.application.dto.GetMyInfoResponseDTO;
import me.assetaid.feature.mypage.application.dto.GetPreferenceResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mypage")
public class MyPageController {

    private final MyPageService myPageService;

    public MyPageController(MyPageService myPageService) {
        this.myPageService = myPageService;
    }

    @GetMapping("/profile/{userId}")
    public ResponseEntity<GetMyInfoResponseDTO> getUserProfile(@PathVariable("userId") String userId) {
        GetMyInfoResponseDTO userProfile = myPageService.getUserProfile(userId);

        if (userProfile != null) {
            return ResponseEntity.ok(userProfile);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/preference/{userId}")
    public ResponseEntity<GetPreferenceResponseDTO> getUserPreference(@PathVariable("userId") String userId) {
        GetPreferenceResponseDTO userPreference = myPageService.getUserPreference(userId);

        if (userPreference != null) {
            return ResponseEntity.ok(userPreference);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

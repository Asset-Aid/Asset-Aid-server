package me.assetaid.feature.mypage.controller;

import me.assetaid.feature.like.controller.BookmarkController;
import me.assetaid.feature.mypage.application.MyPageService;
import me.assetaid.feature.mypage.application.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/goal/delete")
    public ResponseEntity<?> deleteGoal(
            @RequestParam("goalId") Integer goalId,
            @RequestParam("userId") String userId) {

        boolean isDeleted = myPageService.deleteGoal(goalId, userId);
        if (isDeleted) {
            return ResponseEntity.ok("Goal deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PatchMapping("/profile/modify/{userId}")
    public ResponseEntity<?> updateUserProfile(
            @PathVariable("userId") String userId,
            @RequestBody UpdateMyInfoRequestDTO updateRequest) {

        boolean isUpdated = myPageService.updateUserProfile(userId, updateRequest);
        if (isUpdated) {
            return ResponseEntity.ok("Profile updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PatchMapping("/preference/modify/{userId}")
    public ResponseEntity<?> updateUserPreference(
            @PathVariable("userId") String userId,
            @RequestBody UpdatePreferenceRequestDTO updatePreferenceRequestDTO) {

        boolean isUpdated = myPageService.updateUserPreference(userId, updatePreferenceRequestDTO);

        if (isUpdated) {
            return ResponseEntity.ok("User preference updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

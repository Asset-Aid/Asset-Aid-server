package me.assetaid.feature.notification.controller;

import lombok.RequiredArgsConstructor;
import me.assetaid.feature.notification.application.NotificationService;
import me.assetaid.feature.notification.application.dto.CreateNotificationRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public ResponseEntity<?> createNotification(@RequestBody CreateNotificationRequestDTO requestDTO) {
        // CreateNotificationRequestDTO에서 필요한 값을 추출하여 Service로 전달
        return ResponseEntity.ok(
                notificationService.createNotification(
                        requestDTO.getUserId(), // String userId
                        requestDTO.getGoalId(), // Long goalId
                        requestDTO.getCycle()   // String cycle
                )
        );
    }
}


package me.assetaid.feature.notification.controller;

import me.assetaid.feature.notification.application.NotificationService;
import me.assetaid.feature.notification.application.dto.CreateNotificationRequestDTO;
import me.assetaid.feature.notification.application.dto.NotificationResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public NotificationResponseDTO createNotification(@RequestBody CreateNotificationRequestDTO requestDTO) {
        return notificationService.createNotification(requestDTO);
    }

    @GetMapping("/{userId}")
    public List<NotificationResponseDTO> getNotificationsByUserId(@PathVariable String userId) {
        return notificationService.getNotificationsByUserId(userId);
    }
}


package me.assetaid.feature.notification.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class NotificationResponseDTO {
    private String id;         // String 타입
    private Integer userId;    // Integer 타입
    private Long goalId;       // Long 타입
    private LocalDateTime createdAt;
}

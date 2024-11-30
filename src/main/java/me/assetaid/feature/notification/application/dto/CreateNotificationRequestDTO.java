package me.assetaid.feature.notification.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateNotificationRequestDTO {

    private String userId;  // 사용자 ID
    private Long goalId;    // 목표 ID
    private String cycle;   // 알림 주기 (WEEKLY 또는 MONTHLY)
}



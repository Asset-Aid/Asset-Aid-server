package me.assetaid.feature.notification.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateNotificationRequestDTO {
    private String userId; // String으로 변경
    private String goalId;
}


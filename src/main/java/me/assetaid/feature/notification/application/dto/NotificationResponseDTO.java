package me.assetaid.feature.notification.application.dto;

import java.time.LocalDateTime;

public class NotificationResponseDTO {
    private Integer id;
    private String userId;
    private String goalId;
    private LocalDateTime createdAt;

    public NotificationResponseDTO(Integer id, String userId, String goalId, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.goalId = goalId;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGoalId() {
        return goalId;
    }

    public void setGoalId(String goalId) {
        this.goalId = goalId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}


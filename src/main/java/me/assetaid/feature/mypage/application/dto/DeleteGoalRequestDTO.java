package me.assetaid.feature.mypage.application.dto;

public class DeleteGoalRequestDTO {

    private String userId;

    public DeleteGoalRequestDTO() {}

    public DeleteGoalRequestDTO(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

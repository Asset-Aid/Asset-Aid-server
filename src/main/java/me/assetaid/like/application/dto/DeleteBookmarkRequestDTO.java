package me.assetaid.like.application.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DeleteBookmarkRequestDTO {
    private String userId;
    private Integer cardId;
    private Integer depositId;
    private Integer savingId;

    public DeleteBookmarkRequestDTO() {}

    public DeleteBookmarkRequestDTO(String userId, Integer cardId, Integer depositId, Integer savingId) {
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        this.userId = userId;
        this.cardId = cardId;
        this.depositId = depositId;
        this.savingId = savingId;
    }
    public String getUserId() {
        return userId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public Integer getDepositId() {
        return depositId;
    }

    public Integer getSavingId() {
        return savingId;
    }
}

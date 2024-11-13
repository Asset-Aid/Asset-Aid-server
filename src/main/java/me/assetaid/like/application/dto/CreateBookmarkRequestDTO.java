package me.assetaid.like.application.dto;

public class CreateBookmarkRequestDTO {

    private final String userId;
    private final Integer cardId;
    private final Integer depositId;
    private final Integer savingId;

    public CreateBookmarkRequestDTO(String userId, Integer cardId, Integer depositId, Integer savingId) {
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

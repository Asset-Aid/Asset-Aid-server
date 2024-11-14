package me.assetaid.like.application.dto;

public class BookmarkResponseDTO {
    private boolean success;
    private String message;
    private Integer cardBookmarkId;
    private Integer depositBookmarkId;
    private Integer savingBookmarkId;

    public BookmarkResponseDTO(boolean success, String message, Integer cardBookmarkId, Integer depositBookmarkId, Integer savingBookmarkId) {
        this.success = success;
        this.message = message;
        this.cardBookmarkId = cardBookmarkId;
        this.depositBookmarkId = depositBookmarkId;
        this.savingBookmarkId = savingBookmarkId;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCardBookmarkId() {
        return cardBookmarkId;
    }

    public Integer getDepositBookmarkId() {
        return depositBookmarkId;
    }

    public Integer getSavingBookmarkId() {
        return savingBookmarkId;
    }
    public void setCardBookmarkId(Integer cardBookmarkId) {
        this.cardBookmarkId = cardBookmarkId;
    }

    public void setDepositBookmarkId(Integer depositBookmarkId) {
        this.depositBookmarkId = depositBookmarkId;
    }

    public void setSavingBookmarkId(Integer savingBookmarkId) {
        this.savingBookmarkId = savingBookmarkId;
    }
}

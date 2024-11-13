package me.assetaid.like.application.dto;

public class BookmarkDTO {
    private Integer bookmarkId;
    private String userId;
    private String nickname;

    // 생성자
    public BookmarkDTO(Integer bookmarkId, String userId, String nickname) {
        this.bookmarkId = bookmarkId;
        this.userId = userId;
        this.nickname = nickname;
    }

    public Integer getBookmarkId() {
        return bookmarkId;
    }

    public String getUserId() {
        return userId;
    }

    public String getNickname() {
        return nickname;
    }
}

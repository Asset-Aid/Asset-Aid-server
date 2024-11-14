package me.assetaid.like.application.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookmarkDTO {
    private Integer bookmarkId;
    private String userId;
    private String nickname;

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

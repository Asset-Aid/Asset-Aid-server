package me.assetaid.feature.mypage.application.dto;

public class GetMyInfoResponseDTO {

    private String userId;
    private String id;
    private String nickname;

    public GetMyInfoResponseDTO(String userId,String id, String nickname) {
        this.userId = userId;
        this.id = id;
        this.nickname = nickname;
    }

    public String getUserId() {
        return userId;
    }

    public String getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }
}

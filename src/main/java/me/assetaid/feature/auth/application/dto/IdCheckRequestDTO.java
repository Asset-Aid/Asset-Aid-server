package me.assetaid.feature.auth.application.dto;

public class IdCheckRequestDTO {

    private String id;

    // 기본 생성자
    public IdCheckRequestDTO() {}

    // 매개변수가 있는 생성자
    public IdCheckRequestDTO(String id) {
        this.id = id;
    }

    // Getter 및 Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

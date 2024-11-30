package me.assetaid.feature.auth.application.dto;

public class LoginRequestDTO {

    private String id;
    private String password;

    // 기본 생성자
    public LoginRequestDTO() {}

    // 매개변수가 있는 생성자
    public LoginRequestDTO(String id, String password) {
        this.id = id;
        this.password = password;
    }

    // Getter 및 Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
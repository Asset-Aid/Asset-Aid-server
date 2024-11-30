package me.assetaid.feature.auth.application.dto;

public class PasswordCheckRequestDTO {

    private String password;

    // 기본 생성자
    public PasswordCheckRequestDTO() {}

    // 매개변수가 있는 생성자
    public PasswordCheckRequestDTO(String password) {
        this.password = password;
    }

    // Getter 및 Setter
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

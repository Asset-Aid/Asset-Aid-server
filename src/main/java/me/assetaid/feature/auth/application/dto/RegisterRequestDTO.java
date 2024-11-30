package me.assetaid.feature.auth.application.dto;

import java.util.Date;

public class RegisterRequestDTO {

    private String id;
    private String password;
    private String nickname;
    private Date birthday;  // 생일 필드는 선택사항으로 설정

    // 기본 생성자
    public RegisterRequestDTO() {}

    // 매개변수가 있는 생성자
    public RegisterRequestDTO(String id, String password, String nickname, Date birthday) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.birthday = birthday;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "RegisterRequestDTO{id='" + id + "', password='****', nickname='" + nickname + "', birthday='" + (birthday != null ? birthday.toString() : "N/A") + "'}";
    }
}



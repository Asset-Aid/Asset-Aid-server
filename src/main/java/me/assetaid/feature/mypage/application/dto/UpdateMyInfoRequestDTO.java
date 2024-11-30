package me.assetaid.feature.mypage.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class UpdateMyInfoRequestDTO {

    private String id;
    private String password;
    private String nickname;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthday;

    public UpdateMyInfoRequestDTO() {
    }

    public UpdateMyInfoRequestDTO(String id, String password, String nickname, Date birthday) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.birthday = birthday;
    }

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
        return "UpdateMyInfoRequest{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}

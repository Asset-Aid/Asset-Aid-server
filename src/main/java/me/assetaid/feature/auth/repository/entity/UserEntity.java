package me.assetaid.feature.auth.repository.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String password;
    private String nickname;

    @Temporal(TemporalType.DATE)  // 날짜 형식으로 지정
    private Date birthday;  // Date 타입으로 지정

    // 기본 생성자
    public UserEntity() {}

    // 생성자
    public UserEntity(String userId, String password, String nickname, Date birthday) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.birthday = birthday;
    }
}

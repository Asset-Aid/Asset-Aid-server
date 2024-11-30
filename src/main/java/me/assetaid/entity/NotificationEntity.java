package me.assetaid.entity;

import jakarta.persistence.*;
import me.assetaid.element.user.repository.entity.UserEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "notification")
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer notificationId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private LocalDateTime createdAt;  // LocalDateTime으로 변경
    private String goalId;
    private String cycle;

    // userId 필드를 추가하고 getter, setter 메서드를 작성합니다.
    public String getUserId() {
        return user != null ? user.getId() : null;
    }

    public void setUserId(String userId) {
        if (this.user == null) {
            this.user = new UserEntity();  // 유저 객체가 없다면 새로 생성
        }
        this.user.setId(userId);  // user 객체에 userId를 설정
    }

    // createdAt을 LocalDateTime으로 설정
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getGoalId() {
        return goalId;
    }

    public void setGoalId(String goalId) {
        this.goalId = goalId;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }
}

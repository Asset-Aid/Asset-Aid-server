package me.assetaid.feature.notification.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "notification")
@Getter
@Setter
public class NotificationLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id", unique = true, nullable = false)
    private Long id; // 알림 ID

    @Column(name = "user_id", nullable = false)
    private String userId; // 사용자 ID (String)

    @Column(name = "goal_id", nullable = false)
    private Long goalId; // 목표 ID (Long)

    @Column(name = "cycle", nullable = false)
    private String cycle; // 주기 ("WEEKLY", "MONTHLY")

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt; // 알림 생성일
}


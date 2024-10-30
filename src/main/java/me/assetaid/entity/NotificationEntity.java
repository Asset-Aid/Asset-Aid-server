package me.assetaid.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notification")
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer notificationId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private Date createdAt;
    private String goalId;

}

package me.assetaid.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String password;

    private String nickname;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @OneToMany(mappedBy = "user")
    private List<GoalEntity> goals;

    @OneToMany(mappedBy = "user")
    private List<BookmarkEntity> bookmarks;

    @OneToMany(mappedBy = "user")
    private List<NotificationEntity> notifications;

    @OneToOne(mappedBy = "user")
    private PreferenceEntity preference;
}

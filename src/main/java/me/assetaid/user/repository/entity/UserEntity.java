package me.assetaid.user.repository.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import me.assetaid.entity.BookmarkEntity;
import me.assetaid.entity.GoalEntity;
import me.assetaid.entity.NotificationEntity;
import me.assetaid.preference.repository.entity.PreferenceEntity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;

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

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public List<GoalEntity> getGoals() {
        return goals;
    }

    public void setGoals(List<GoalEntity> goals) {
        this.goals = goals;
    }

    public List<BookmarkEntity> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(List<BookmarkEntity> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public List<NotificationEntity> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<NotificationEntity> notifications) {
        this.notifications = notifications;
    }

    public PreferenceEntity getPreference() {
        return preference;
    }

    public void setPreference(PreferenceEntity preference) {
        this.preference = preference;
    }
}

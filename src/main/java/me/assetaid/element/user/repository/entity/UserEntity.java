package me.assetaid.element.user.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import me.assetaid.feature.goal.repository.entity.GoalEntity;
import me.assetaid.entity.NotificationEntity;
import me.assetaid.feature.preference.repository.entity.PreferenceEntity;
import me.assetaid.feature.like.repository.entity.CardBookmarkEntity;
import me.assetaid.feature.like.repository.entity.DepositBookmarkEntity;
import me.assetaid.feature.like.repository.entity.SavingBookmarkEntity;

import java.util.Date;
import java.util.List;

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
    @JsonBackReference
    private List<CardBookmarkEntity> cardBookmarks;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<DepositBookmarkEntity> depositBookmarks;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<SavingBookmarkEntity> savingBookmarks;

    @OneToMany(mappedBy = "user")
    private List<NotificationEntity> notifications;

    @OneToOne(mappedBy = "user")
    private PreferenceEntity preference;

    // Getter and Setter methods

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

    public List<CardBookmarkEntity> getCardBookmarks() {
        return cardBookmarks;
    }

    public void setCardBookmarks(List<CardBookmarkEntity> cardBookmarks) {
        this.cardBookmarks = cardBookmarks;
    }

    public List<DepositBookmarkEntity> getDepositBookmarks() {
        return depositBookmarks;
    }

    public void setDepositBookmarks(List<DepositBookmarkEntity> depositBookmarks) {
        this.depositBookmarks = depositBookmarks;
    }

    public List<SavingBookmarkEntity> getSavingBookmarks() {
        return savingBookmarks;
    }

    public void setSavingBookmarks(List<SavingBookmarkEntity> savingBookmarks) {
        this.savingBookmarks = savingBookmarks;
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

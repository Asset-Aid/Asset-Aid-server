package me.assetaid.like.repository.entity;

import jakarta.persistence.*;
import me.assetaid.saving.repository.entity.SavingEntity;
import me.assetaid.user.repository.entity.UserEntity;

@Entity
@Table(name = "saving_bookmark")
public class SavingBookmarkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer savingBookmarkId;

    @ManyToOne
    @JoinColumn(name = "saving_id")
    private SavingEntity saving;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public Integer getSavingBookmarkId() {
        return savingBookmarkId;
    }

    public void setSavingBookmarkId(Integer savingBookmarkId) {
        this.savingBookmarkId = savingBookmarkId;
    }

    public SavingEntity getSaving() {
        return saving;
    }

    public void setSaving(SavingEntity saving) {
        this.saving = saving;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}

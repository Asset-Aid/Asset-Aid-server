package me.assetaid.feature.like.repository.entity;

import jakarta.persistence.*;
import me.assetaid.element.deposit.repository.entity.DepositEntity;
import me.assetaid.element.user.repository.entity.UserEntity;

@Entity
@Table(name = "deposit_bookmark")
public class DepositBookmarkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer depositBookmarkId;

    @ManyToOne
    @JoinColumn(name = "deposit_id")
    private DepositEntity deposit;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public Integer getDepositBookmarkId() {
        return depositBookmarkId;
    }

    public void setDepositBookmarkId(Integer depositBookmarkId) {
        this.depositBookmarkId = depositBookmarkId;
    }

    public DepositEntity getDeposit() {
        return deposit;
    }

    public void setDeposit(DepositEntity deposit) {
        this.deposit = deposit;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}

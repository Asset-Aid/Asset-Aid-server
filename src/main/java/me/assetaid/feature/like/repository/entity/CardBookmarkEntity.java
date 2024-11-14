package me.assetaid.feature.like.repository.entity;

import jakarta.persistence.*;
import me.assetaid.element.card.repository.entity.CardEntity;
import me.assetaid.element.user.repository.entity.UserEntity;

@Entity
@Table(name = "card_bookmark")
public class CardBookmarkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardBookmarkId;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private CardEntity card;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public Integer getCardBookmarkId() {
        return cardBookmarkId;
    }

    public void setCardBookmarkId(Integer cardBookmarkId) {
        this.cardBookmarkId = cardBookmarkId;
    }

    public CardEntity getCard() {
        return card;
    }

    public void setCard(CardEntity card) {
        this.card = card;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}

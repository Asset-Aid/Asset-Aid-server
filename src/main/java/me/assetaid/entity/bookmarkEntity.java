package me.assetaid.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bookmark")
public class BookmarkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookmarkId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private userEntity user;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private cardEntity card;

    @ManyToOne
    @JoinColumn(name = "deposit_id")
    private depositEntity deposit;

    @ManyToOne
    @JoinColumn(name = "saving_id")
    private savingEntity saving;
}

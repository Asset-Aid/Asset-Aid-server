package me.assetaid.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "card")
public class cardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardId;

    private String benefit;
    private Integer annualFee;
    private String cardType;
    private Integer performance;
    private Integer cardLimit;
    private String bank;
    private String cardName;

    @Column(length = 1000)
    private String cardImage;

    // 연관관계 설정
    @OneToMany(mappedBy = "card")
    private List<bookmarkEntity> bookmarks;
}

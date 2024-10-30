package me.assetaid.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "card")
public class CardEntity {
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
    private String url;

    @Column(length = 5000)
    private String content;

    @Column(length = 1000)
    private String cardImage;

    // 연관관계 설정
    @OneToMany(mappedBy = "card")
    private List<BookmarkEntity> bookmarks;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

package me.assetaid.element.card.repository.entity;

import jakarta.persistence.*;
import me.assetaid.feature.like.repository.entity.CardBookmarkEntity;

import java.util.List;

@Entity
@Table(name = "card")
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardId;

    private String benefit;
    private Integer annualFee;
    private Integer cardType;
    private Integer performance;
    private Integer cardLimit;
    private String bank;
    private String cardName;
    private String url;
    private Integer annualFeeKor;
    private Integer annualFeeFor;

    @Column(length = 5000)
    private String content;

    @Column(length = 1000)
    private String cardImage;


    @OneToMany(mappedBy = "card")
    private List<CardBookmarkEntity> bookmarks;

    public Integer getCardId() {
        return cardId;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    public Integer getAnnualFee() {
        return annualFee;
    }
    public void setAnnualFee(Integer annualFee) {
        this.annualFee = annualFee;
    }

    public void setAnnualFeeFor(Integer annualFeeFor) {
        this.annualFeeFor = annualFeeFor;
    }
    public Integer getAnnualFeeFor() {
        return annualFeeFor;
    }

    public void setAnnualFeeKor(Integer annualFeeKor) {
        this.annualFeeKor = annualFeeKor;
    }
    public Integer getAnnualFeeKor() {
        return annualFeeKor;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Integer getPerformance() {
        return performance;
    }

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }

    public Integer getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(Integer cardLimit) {
        this.cardLimit = cardLimit;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

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

    public String getCardImage() {
        return cardImage;
    }

    public void setCardImage(String cardImage) {
        this.cardImage = cardImage;
    }
}

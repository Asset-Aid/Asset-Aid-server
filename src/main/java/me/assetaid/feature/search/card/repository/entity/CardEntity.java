package me.assetaid.feature.search.card.repository.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity(name = "CardEntitySearch")
@Table(name = "card")
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    private String cardName;
    private String bank;
    private String benefits; // "주유 할인, 음식 할인" 형태로 저장
    private Integer cardType;
    private Integer annualFeeKor;
    private Integer annualFeeFor;
    private Integer cardLimit;

    // Getters and Setters
    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Integer getAnnualFeeKor() {
        return annualFeeKor;
    }

    public void setAnnualFeeKor(Integer annualFeeKor) {
        this.annualFeeKor = annualFeeKor;
    }

    public Integer getAnnualFeeFor() {
        return annualFeeFor;
    }

    public void setAnnualFeeFor(Integer annualFeeFor) {
        this.annualFeeFor = annualFeeFor;
    }

    public Integer getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(Integer cardLimit) {
        this.cardLimit = cardLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardEntity that = (CardEntity) o;
        return Objects.equals(cardId, that.cardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId);
    }
}

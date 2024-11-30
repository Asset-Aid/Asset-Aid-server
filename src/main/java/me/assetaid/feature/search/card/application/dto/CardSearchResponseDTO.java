package me.assetaid.feature.search.card.application.dto;

public class CardSearchResponseDTO {

    private Long cardId;
    private String cardName;
    private String bank;
    private String benefits; // 문자열 형태로 반환
    private Integer cardType;
    private Integer annualFeeKor;
    private Integer annualFeeFor;
    private Integer cardLimit;

    public CardSearchResponseDTO(Long cardId, String cardName, String bank, String benefits,
                                 Integer cardType, Integer annualFeeKor, Integer annualFeeFor, Integer cardLimit) {
        this.cardId = cardId;
        this.cardName = cardName;
        this.bank = bank;
        this.benefits = benefits;
        this.cardType = cardType;
        this.annualFeeKor = annualFeeKor;
        this.annualFeeFor = annualFeeFor;
        this.cardLimit = cardLimit;
    }

    // Getters
    public Long getCardId() {
        return cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public String getBank() {
        return bank;
    }

    public String getBenefits() {
        return benefits;
    }

    public Integer getCardType() {
        return cardType;
    }

    public Integer getAnnualFeeKor() {
        return annualFeeKor;
    }

    public Integer getAnnualFeeFor() {
        return annualFeeFor;
    }

    public Integer getCardLimit() {
        return cardLimit;
    }
}


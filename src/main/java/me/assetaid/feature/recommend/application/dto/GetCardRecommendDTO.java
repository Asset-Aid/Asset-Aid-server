package me.assetaid.feature.recommend.application.dto;

public class GetCardRecommendDTO {
    private Integer cardId;
    private String cardName;
    private String bank;
    private String bankColor;

    public GetCardRecommendDTO(Integer cardId, String cardName, String bank, String bankColor) {
        this.cardId = cardId;
        this.cardName = cardName;
        this.bank = bank;
        this.bankColor = bankColor;
    }

    public Integer getCardId() {
        return cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public String getBank() {
        return bank;
    }

    public String getBankColor() {
        return bankColor;
    }
}

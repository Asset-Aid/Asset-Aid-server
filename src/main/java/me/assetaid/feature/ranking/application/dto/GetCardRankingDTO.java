package me.assetaid.feature.ranking.application.dto;

public class GetCardRankingDTO {
    private Integer cardId;
    private String cardName;
    private String bank;

    public GetCardRankingDTO(Integer cardId, String cardName, String bank) {
        this.cardId = cardId;
        this.cardName = cardName;
        this.bank = bank;
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
}

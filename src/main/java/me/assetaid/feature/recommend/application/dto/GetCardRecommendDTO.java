package me.assetaid.feature.recommend.application.dto;

import java.util.List;

public class GetCardRecommendDTO {
    private Integer cardId;
    private String cardName;
    private List<Integer> bankId;
    private String bankColor;

    public GetCardRecommendDTO(Integer cardId, String cardName, List<Integer> bankId, String bankColor) {
        this.cardId = cardId;
        this.cardName = cardName;
        this.bankId = bankId;
        this.bankColor = bankColor;
    }

    public Integer getCardId() { return cardId; }
    public String getCardName() { return cardName; }
    public List<Integer> getBankId() { return bankId; }
    public String getBankColor() { return bankColor; }
}

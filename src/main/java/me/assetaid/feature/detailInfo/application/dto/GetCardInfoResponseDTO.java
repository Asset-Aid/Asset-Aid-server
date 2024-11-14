package me.assetaid.feature.detailInfo.application.dto;

public class GetCardInfoResponseDTO {

    private Integer cardId;
    private String annualFeeFor;
    private String annualFeeKor;
    private Integer cardLimit;
    private String cardType;
    private String cardImage;
    private String bank;
    private String benefit;
    private String cardName;

    public GetCardInfoResponseDTO(Integer cardId, String annualFeeFor, String annualFeeKor, Integer cardLimit,
                                  String cardType, String cardImage, String bank, String benefit, String cardName) {
        this.cardId = cardId;
        this.annualFeeFor = annualFeeFor;
        this.annualFeeKor = annualFeeKor;
        this.cardLimit = cardLimit;
        this.cardType = cardType;
        this.cardImage = cardImage;
        this.bank = bank;
        this.benefit = benefit;
        this.cardName = cardName;
    }

    public Integer getCardId() {
        return cardId;
    }

    public String getAnnualFeeFor() {
        return annualFeeFor;
    }

    public String getAnnualFeeKor() {
        return annualFeeKor;
    }

    public Integer getCardLimit() {
        return cardLimit;
    }

    public String getCardType() {
        return cardType;
    }

    public String getCardImage() {
        return cardImage;
    }

    public String getBank() {
        return bank;
    }

    public String getBenefit() {
        return benefit;
    }

    public String getCardName() {
        return cardName;
    }
}

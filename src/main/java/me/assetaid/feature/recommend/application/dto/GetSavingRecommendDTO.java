package me.assetaid.feature.recommend.application.dto;

public class GetSavingRecommendDTO {
    private Integer savingId;
    private String savingName;
    private String bank;
    private String bankColor;

    public GetSavingRecommendDTO(Integer savingId, String savingName, String bank, String bankColor) {
        this.savingId = savingId;
        this.savingName = savingName;
        this.bank = bank;
        this.bankColor = bankColor;
    }

    public Integer getSavingId() {
        return savingId;
    }

    public String getSavingName() {
        return savingName;
    }

    public String getBank() {
        return bank;
    }

    public String getBankColor() {
        return bankColor;
    }
}

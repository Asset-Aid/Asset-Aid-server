package me.assetaid.feature.ranking.application.dto;

public class GetSavingRankingDTO {
    private Integer savingId;
    private String savingName;
    private String bank;

    public GetSavingRankingDTO(Integer savingId, String savingName, String bank) {
        this.savingId = savingId;
        this.savingName = savingName;
        this.bank = bank;
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
}

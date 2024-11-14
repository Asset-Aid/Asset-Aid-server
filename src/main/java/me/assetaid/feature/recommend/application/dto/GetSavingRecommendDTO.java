package me.assetaid.feature.recommend.application.dto;

import java.util.List;

public class GetSavingRecommendDTO {
    private Integer savingId;
    private String savingName;
    private List<Integer> bankId;
    private String bankColor;

    public GetSavingRecommendDTO(Integer savingId, String savingName, List<Integer> bankId, String bankColor) {
        this.savingId = savingId;
        this.savingName = savingName;
        this.bankId = bankId;
        this.bankColor = bankColor;
    }

    public Integer getSavingId() { return savingId; }
    public String getSavingName() { return savingName; }
    public List<Integer> getBankId() { return bankId; }
    public String getBankColor() { return bankColor; }
}

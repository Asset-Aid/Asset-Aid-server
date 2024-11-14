package me.assetaid.feature.recommend.application.dto;

import java.util.List;

public class GetDepositRecommendDTO {
    private Integer depositId;
    private String depositName;
    private List<Integer> bankId;
    private String bankColor;

    public GetDepositRecommendDTO(Integer depositId, String depositName, List<Integer> bankId, String bankColor) {
        this.depositId = depositId;
        this.depositName = depositName;
        this.bankId = bankId;
        this.bankColor = bankColor;
    }

    public Integer getDepositId() { return depositId; }
    public String getDepositName() { return depositName; }
    public List<Integer> getBankId() { return bankId; }
    public String getBankColor() { return bankColor; }
}

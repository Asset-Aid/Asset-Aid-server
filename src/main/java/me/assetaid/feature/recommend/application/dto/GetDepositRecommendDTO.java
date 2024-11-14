package me.assetaid.feature.recommend.application.dto;

public class GetDepositRecommendDTO {
    private Integer depositId;
    private String depositName;
    private Integer bankId;
    private String bankColor;

    public GetDepositRecommendDTO(Integer depositId, String depositName, Integer bankId, String bankColor) {
        this.depositId = depositId;
        this.depositName = depositName;
        this.bankId = bankId;
        this.bankColor = bankColor;
    }
    public Integer getDepositId() { return depositId; }
    public String getDepositName() { return depositName; }
    public Integer getBankId() { return bankId; }
    public String getBankColor() { return bankColor; }
}

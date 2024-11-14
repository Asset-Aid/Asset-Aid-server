package me.assetaid.feature.ranking.application.dto;

public class GetDepositRankingDTO {

    private String depositName;
    private String bank;
    private Integer depositId;

    public GetDepositRankingDTO(Integer depositId,String depositName, String bank) {
        this.depositName = depositName;
        this.bank = bank;
        this.depositId = depositId;
    }

    public String getDepositName() {
        return depositName;
    }

    public void setDepositName(String depositName) {
        this.depositName = depositName;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
    public Integer getDepositId() {
        return depositId;
    }

    public void setDepositId(Integer depositId) {
        this.depositId = depositId;
    }

}

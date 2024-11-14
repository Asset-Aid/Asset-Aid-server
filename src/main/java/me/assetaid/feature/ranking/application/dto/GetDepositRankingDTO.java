package me.assetaid.feature.ranking.application.dto;

public class GetDepositRankingDTO {

    private String depositName;
    private String bank;

    public GetDepositRankingDTO(String depositName, String bank) {
        this.depositName = depositName;
        this.bank = bank;
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
}

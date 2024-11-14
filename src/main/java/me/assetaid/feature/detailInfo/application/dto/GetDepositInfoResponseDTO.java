package me.assetaid.feature.detailInfo.application.dto;

public class GetDepositInfoResponseDTO {

    private Integer depositId;
    private String depositName;
    private String bank;
    private String joinWay;
    private String startAt;
    private String endAt;
    private Integer limitDeposit;
    private String contents;
    private Double intRate;

    public GetDepositInfoResponseDTO(Integer depositId, String depositName, String bank, String joinWay,
                                     String startAt, String endAt, Integer limitDeposit, String contents, Double intRate) {
        this.depositId = depositId;
        this.depositName = depositName;
        this.bank = bank;
        this.joinWay = joinWay;
        this.startAt = startAt;
        this.endAt = endAt;
        this.limitDeposit = limitDeposit;
        this.contents = contents;
        this.intRate = intRate;
    }

    public Integer getDepositId() {
        return depositId;
    }

    public String getDepositName() {
        return depositName;
    }

    public String getBank() {
        return bank;
    }

    public String getJoinWay() {
        return joinWay;
    }

    public String getStartAt() {
        return startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public Integer getLimitDeposit() {
        return limitDeposit;
    }

    public String getContents() {
        return contents;
    }
    public Double getIntRate() {
        return intRate;
    }
}


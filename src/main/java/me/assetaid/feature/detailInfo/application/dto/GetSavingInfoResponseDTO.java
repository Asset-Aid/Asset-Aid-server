package me.assetaid.feature.detailInfo.application.dto;

public class GetSavingInfoResponseDTO {

    private Integer savingId;
    private String savingName;
    private String bank;
    private String joinWay;
    private String startAt;
    private String endAt;
    private Integer limitDeposit;
    private String contents;

    public GetSavingInfoResponseDTO(Integer savingId, String savingName, String bank, String joinWay,
                                    String startAt, String endAt, Integer limitDeposit, String contents) {
        this.savingId = savingId;
        this.savingName = savingName;
        this.bank = bank;
        this.joinWay = joinWay;
        this.startAt = startAt;
        this.endAt = endAt;
        this.limitDeposit = limitDeposit;
        this.contents = contents;
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
}

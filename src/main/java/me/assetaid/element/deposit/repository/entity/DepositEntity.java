package me.assetaid.element.deposit.repository.entity;

import jakarta.persistence.*;
import me.assetaid.feature.like.repository.entity.DepositBookmarkEntity;

import java.util.List;

@Entity
@Table(name = "deposit")
public class DepositEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer depositId;

    private String depositName;
    private String bank;
    private String joinWay;
    private String startAt;
    private String endAt;
    private String depositInfo;
    private String intRateType;
    private Double intRate;
    private Integer saveTerm;
    private String saveTermType;
    private Integer limitDeposit;
    private String contents;

    @OneToMany(mappedBy = "deposit")
    private List<DepositBookmarkEntity> bookmarks;

    // Getters and Setters
    public Integer getDepositId() { return depositId; }
    public void setDepositId(Integer depositId) { this.depositId = depositId; }

    public String getDepositName() { return depositName; }
    public void setDepositName(String depositName) { this.depositName = depositName; }

    public String getBank() { return bank; }
    public void setBank(String bank) { this.bank = bank; }

    public String getJoinWay() { return joinWay; }
    public void setJoinWay(String joinWay) { this.joinWay = joinWay; }

    public String getStartAt() { return startAt; }
    public void setStartAt(String startAt) { this.startAt = startAt; }

    public String getEndAt() { return endAt; }
    public void setEndAt(String endAt) { this.endAt = endAt; }

    public String getDepositInfo() { return depositInfo; }
    public void setDepositInfo(String depositInfo) { this.depositInfo = depositInfo; }

    public String getIntRateType() { return intRateType; }
    public void setIntRateType(String intRateType) { this.intRateType = intRateType; }

    public Double getIntRate() { return intRate; }
    public void setIntRate(Double intRate) { this.intRate = intRate; }

    public Integer getSaveTerm() { return saveTerm; }
    public void setSaveTerm(Integer saveTerm) { this.saveTerm = saveTerm; }

    public String getSaveTermType() { return saveTermType; }
    public void setSaveTermType(String saveTermType) { this.saveTermType = saveTermType; }

    public Integer getLimitDeposit() { return limitDeposit; }
    public void setLimitDeposit(Integer limitDeposit) { this.limitDeposit = limitDeposit; }

    public String getContents() { return contents; }
    public void setContents(String contents) { this.contents = contents; }

    public List<DepositBookmarkEntity> getBookmarks() { return bookmarks; }
    public void setBookmarks(List<DepositBookmarkEntity> bookmarks) { this.bookmarks = bookmarks; }
}

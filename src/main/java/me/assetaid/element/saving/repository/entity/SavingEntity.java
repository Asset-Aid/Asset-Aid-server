package me.assetaid.element.saving.repository.entity;

import jakarta.persistence.*;
import me.assetaid.feature.like.repository.entity.SavingBookmarkEntity;

import java.util.List;

@Entity
@Table(name = "saving")
public class SavingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer savingId;

    private String savingName;
    private String bank;
    private String joinWay;
    private String startAt;
    private String endAt;
    private String savingInfo;
    private String rsrvRateType;
    private Integer rsrvRate;
    private Integer saveTerm;
    private String saveTermType;
    private Integer limitSaving;
    private String contents;

    private Long viewCount = 0L;

    @OneToMany(mappedBy = "saving")
    private List<SavingBookmarkEntity> bookmarks;

    public Integer getSavingId() { return savingId; }
    public void setSavingId(Integer savingId) { this.savingId = savingId; }

    public String getSavingName() { return savingName; }
    public void setSavingName(String savingName) { this.savingName = savingName; }

    public String getBank() { return bank; }
    public void setBank(String bank) { this.bank = bank; }

    public String getJoinWay() { return joinWay; }
    public void setJoinWay(String joinWay) { this.joinWay = joinWay; }

    public String getStartAt() { return startAt; }
    public void setStartAt(String startAt) { this.startAt = startAt; }

    public String getEndAt() { return endAt; }
    public void setEndAt(String endAt) { this.endAt = endAt; }

    public String getSavingInfo() { return savingInfo; }
    public void setSavingInfo(String savingInfo) { this.savingInfo = savingInfo; }

    public String getRsrvRateType() { return rsrvRateType; }
    public void setRsrvRateType(String rsrvRateType) { this.rsrvRateType = rsrvRateType; }

    public Integer getRsrvRate() { return rsrvRate; }
    public void setRsrvRate(Integer rsrvRate) { this.rsrvRate = rsrvRate; }

    public Integer getSaveTerm() { return saveTerm; }
    public void setSaveTerm(Integer saveTerm) { this.saveTerm = saveTerm; }

    public String getSaveTermType() { return saveTermType; }
    public void setSaveTermType(String saveTermType) { this.saveTermType = saveTermType; }

    public Integer getLimitSaving() { return limitSaving; }
    public void setLimitSaving(Integer limitSaving) { this.limitSaving = limitSaving; }

    public String getContents() { return contents; }
    public void setContents(String contents) { this.contents = contents; }

    public List<SavingBookmarkEntity> getBookmarks() { return bookmarks; }
    public void setBookmarks(List<SavingBookmarkEntity> bookmarks) { this.bookmarks = bookmarks; }

    public Long getViewCount() {return viewCount;}
    public void setViewCount(Long viewCount) {this.viewCount = viewCount;}
}

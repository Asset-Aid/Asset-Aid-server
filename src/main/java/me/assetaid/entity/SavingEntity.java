package me.assetaid.entity;

import jakarta.persistence.*;
import java.util.Date;
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
    private Date startAt;
    private Date endAt;
    private String savingInfo;
    private String rsrvRateType;
    private Integer rsrvRate;
    private Integer saveTerm;
    private String saveTermType;
    private Integer limit;
    private String contents;
    // 연관관계 설정
    @OneToMany(mappedBy = "saving")
    private List<BookmarkEntity> bookmarks;
}

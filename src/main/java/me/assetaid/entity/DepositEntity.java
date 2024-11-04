package me.assetaid.entity;

import jakarta.persistence.*;
import java.util.Date;
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
    private Date startAt;
    private Date endAt;
    private String depositInfo;
    private String intRateType;
    private Integer intRate;
    private Integer saveTerm;
    private String saveTermType;
    private Integer limit;
    private String contents;

    // 연관관계 설정
    @OneToMany(mappedBy = "deposit")
    private List<BookmarkEntity> bookmarks;

}

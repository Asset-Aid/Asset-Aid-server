package me.assetaid.feature.search.savings.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "savings")
public class SavingsEntity {

    @Id
    private Long savingId; // ID 필드

    @Column(nullable = false)
    private String savingName; // 상품명

    @Column(nullable = false)
    private String bankName; // 은행명

    @Column(nullable = false)
    private String startAt; // 시작일

    @Column
    private String endAt; // 종료일 (null 가능)

    @Column(nullable = false)
    private Integer limitDeposit; // 최대 납입 금액

    @Column(nullable = false)
    private String contents; // 적금 관련 상세 정보 (기본 금리 및 최고 금리 포함)
}


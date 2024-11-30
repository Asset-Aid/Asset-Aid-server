package me.assetaid.feature.search.savings.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SavingsSearchResponseDTO {

    private String savingName;        // 상품명
    private String bankName;          // 은행
    private String joinPeriod;        // 가입 기간 (startAt ~ endAt)
    private Integer maxDepositAmount; // 최대 납입 금액
    private Double baseRate;          // 기본 금리
    private Double maxRate;           // 최고 금리
}



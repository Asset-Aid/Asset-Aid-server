package me.assetaid.feature.search.savings.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SavingsSearchRequestDTO {
    private List<String> bankNames; // 은행 이름 리스트
    private String savingsType;    // "정액적립식" 또는 "자유적립식"
    private Integer minTerm;       // 최소 가입 기간
    private Integer maxTerm;       // 최대 가입 기간
    private Double minAmount;      // 최소 가입 금액
}


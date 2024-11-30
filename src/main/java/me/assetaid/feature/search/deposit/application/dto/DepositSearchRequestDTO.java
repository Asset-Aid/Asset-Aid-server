package me.assetaid.feature.search.deposit.application.dto;

import java.util.List;

public class DepositSearchRequestDTO {
    private List<String> bankNames;  // 은행 이름 리스트
    private String depositType;      // 예금 형식 (입출금, 정기예금 등)
    private int savingTerm;          // 최소 가입 기간

    // Getters and Setters
    public List<String> getBankNames() {
        return bankNames;
    }

    public void setBankNames(List<String> bankNames) {
        this.bankNames = bankNames;
    }

    public String getDepositType() {
        return depositType;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }

    public int getSavingTerm() {
        return savingTerm;
    }

    public void setSavingTerm(int savingTerm) {
        this.savingTerm = savingTerm;
    }
}


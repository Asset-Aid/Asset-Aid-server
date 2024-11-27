package me.assetaid.feature.search.deposit.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DepositEntity {
    @Id
    private Long id;                 // 기본 키
    private String productName;      // 상품명
    private String bankName;         // 은행 이름
    private String salesPeriod;      // 판매 기간
    private int savingTerm;          // 가입 기간
    private double subscriptionAmount; // 가입 금액
    private double basicInterestRate; // 기본 금리
    private double maxInterestRate;   // 최고 금리

    // Getters
    public String getProductName() {
        return productName;
    }

    public String getBankName() {
        return bankName;
    }

    public String getSalesPeriod() {
        return salesPeriod;
    }

    public int getSavingTerm() {
        return savingTerm;
    }

    public double getSubscriptionAmount() {
        return subscriptionAmount;
    }

    public double getBasicInterestRate() {
        return basicInterestRate;
    }

    public double getMaxInterestRate() {
        return maxInterestRate;
    }

    // Setters (필요한 경우 추가)
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setSalesPeriod(String salesPeriod) {
        this.salesPeriod = salesPeriod;
    }

    public void setSavingTerm(int savingTerm) {
        this.savingTerm = savingTerm;
    }

    public void setSubscriptionAmount(double subscriptionAmount) {
        this.subscriptionAmount = subscriptionAmount;
    }

    public void setBasicInterestRate(double basicInterestRate) {
        this.basicInterestRate = basicInterestRate;
    }

    public void setMaxInterestRate(double maxInterestRate) {
        this.maxInterestRate = maxInterestRate;
    }
}






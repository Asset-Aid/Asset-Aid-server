package me.assetaid.feature.mypage.application.dto;

import java.util.List;

public class GetPreferenceResponseDTO {

    private Integer availableAmount;
    private String bank;
    private List<Integer> bankId;
    private Integer debt;
    private String investmentStyle;
    private String job;
    private String knowledgeLevel;
    private Integer salary;
    private Integer spend;
    private String userId;

    public GetPreferenceResponseDTO(Integer availableAmount, String bank, List<Integer> bankId, Integer debt,
                                    String investmentStyle, String job, String knowledgeLevel,
                                    Integer salary, Integer spend, String userId) {
        this.availableAmount = availableAmount;
        this.bank = bank;
        this.bankId = bankId;
        this.debt = debt;
        this.investmentStyle = investmentStyle;
        this.job = job;
        this.knowledgeLevel = knowledgeLevel;
        this.salary = salary;
        this.spend = spend;
        this.userId = userId;
    }

    public Integer getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(Integer availableAmount) {
        this.availableAmount = availableAmount;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public List<Integer> getBankId() {
        return bankId;
    }

    public void setBankId(List<Integer> bankId) {
        this.bankId = bankId;
    }

    public Integer getDebt() {
        return debt;
    }

    public void setDebt(Integer debt) {
        this.debt = debt;
    }

    public String getInvestmentStyle() {
        return investmentStyle;
    }

    public void setInvestmentStyle(String investmentStyle) {
        this.investmentStyle = investmentStyle;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getKnowledgeLevel() {
        return knowledgeLevel;
    }

    public void setKnowledgeLevel(String knowledgeLevel) {
        this.knowledgeLevel = knowledgeLevel;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getSpend() {
        return spend;
    }

    public void setSpend(Integer spend) {
        this.spend = spend;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
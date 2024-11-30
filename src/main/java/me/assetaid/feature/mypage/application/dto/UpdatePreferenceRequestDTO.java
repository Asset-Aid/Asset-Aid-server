package me.assetaid.feature.mypage.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdatePreferenceRequestDTO {

    @JsonProperty("available_amount")
    private Integer availableAmount;

    @JsonProperty("debt")
    private Integer debt;

    @JsonProperty("investment_style")
    private String investmentStyle;

    @JsonProperty("job")
    private String job;

    @JsonProperty("knowledge_level")
    private String knowledgeLevel;

    @JsonProperty("salary")
    private Integer salary;

    @JsonProperty("spend")
    private Integer spend;

    public UpdatePreferenceRequestDTO() {}

    public UpdatePreferenceRequestDTO(Integer availableAmount, Integer debt, String investmentStyle, String job, String knowledgeLevel, Integer salary, Integer spend) {
        this.availableAmount = availableAmount;
        this.debt = debt;
        this.investmentStyle = investmentStyle;
        this.job = job;
        this.knowledgeLevel = knowledgeLevel;
        this.salary = salary;
        this.spend = spend;
    }

    public Integer getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(Integer availableAmount) {
        this.availableAmount = availableAmount;
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
}

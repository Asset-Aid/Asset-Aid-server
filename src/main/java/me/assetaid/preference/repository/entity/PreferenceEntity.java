package me.assetaid.preference.repository.entity;

import me.assetaid.user.repository.entity.UserEntity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "preference")
public class PreferenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer preferenceId;

    private Integer availableAmount;
    private Integer debt;
    private Integer salary;
    private Integer spend;
    private String investmentStyle;
    private String job;
    private String knowledgeLevel;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private UserEntity user;
    public PreferenceEntity(Integer availableAmount, Integer debt, Integer salary, Integer spend,
                            String investmentStyle, String job, String knowledgeLevel, UserEntity user) {
        this.availableAmount = availableAmount;
        this.debt = debt;
        this.salary = salary;
        this.spend = spend;
        this.investmentStyle = investmentStyle;
        this.job = job;
        this.knowledgeLevel = knowledgeLevel;
        this.user = user;
    }

    public Integer getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(Integer preferenceId) {
        this.preferenceId = preferenceId;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getDebt() {
        return debt;
    }

    public void setDebt(Integer debt) {
        this.debt = debt;
    }

    public Integer getSpend() {
        return spend;
    }

    public void setSpend(Integer spend) {
        this.spend = spend;
    }

    public String getKnowledgeLevel() {
        return knowledgeLevel;
    }

    public void setKnowledgeLevel(String knowledgeLevel) {
        this.knowledgeLevel = knowledgeLevel;
    }

    public Integer getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(Integer availableAmount) {
        this.availableAmount = availableAmount;
    }

    public String getInvestmentStyle() {
        return investmentStyle;
    }

    public void setInvestmentStyle(String investmentStyle) {
        this.investmentStyle = investmentStyle;
    }
}

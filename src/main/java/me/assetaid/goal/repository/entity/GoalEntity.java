package me.assetaid.goal.repository.entity;

import jakarta.persistence.*;
import me.assetaid.user.repository.entity.UserEntity;

import java.util.Date;

@Entity
@Table(name = "goal")
public class GoalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long goalId;

    private String goalType;
    private String purpose;
    private Integer hopeAmount;
    private Date dueDate;
    private String cycle;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    public GoalEntity() {
    }
    public GoalEntity(String goalType, String purpose, Integer hopeAmount, Date dueDate, String cycle, UserEntity user) {
        this.goalType = goalType;
        this.purpose = purpose;
        this.hopeAmount = hopeAmount;
        this.dueDate = dueDate;
        this.cycle = cycle;
        this.user = user;
    }

    public Long getGoalId() {
        return goalId;
    }

    public void setGoalId(Long goalId) {
        this.goalId = goalId;
    }

    public String getGoalType() {
        return goalType;
    }

    public void setGoalType(String goalType) {
        this.goalType = goalType;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Integer getHopeAmount() {
        return hopeAmount;
    }

    public void setHopeAmount(Integer hopeAmount) {
        this.hopeAmount = hopeAmount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}

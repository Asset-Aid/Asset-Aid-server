package me.assetaid.feature.goal.repository.entity;

import jakarta.persistence.*;
import me.assetaid.element.user.repository.entity.UserEntity;

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

    public void getGoalId(Long goalId) {
        this.goalId = goalId;
    }

    public String getGoalType() {
        return goalType;
    }

    public String getPurpose() {
        return purpose;
    }

    public Integer getHopeAmount() {
        return hopeAmount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public String getCycle() {
        return cycle;
    }

    public UserEntity getUser() {
        return user;
    }

}

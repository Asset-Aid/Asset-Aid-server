package me.assetaid.entity;

import jakarta.persistence.*;
import me.assetaid.user.repository.entity.UserEntity;

import java.util.Date;

@Entity
@Table(name = "goal")
public class GoalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer goalId;

    private String goalType;
    private String purpose;
    private Integer hopeAmount;
    private Date dueDate;
    private String cycle;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}

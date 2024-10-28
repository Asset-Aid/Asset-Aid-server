package me.assetaid.entity;

import jakarta.persistence.*;
import java.util.Date;

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

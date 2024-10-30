package me.assetaid.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "preference")
public class PreferenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer preferenceId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private String job;
    private Integer salary;
    private Integer debt;
    private Integer spend;
    private String knowledgeLevel;
    private Integer availableAmount;
    private String investmentStyle;
}

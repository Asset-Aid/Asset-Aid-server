package me.assetaid.feature.goal.application.dto;

import me.assetaid.feature.goal.repository.entity.GoalEntity;

import java.time.LocalDate;
import java.time.ZoneId;

public class GetGoalResponseDTO {
    private final Integer hopeAmount;
    private final String purpose;
    private final String cycle;
    private final LocalDate dueDate;
    private final String nickname;

    public GetGoalResponseDTO(Integer hopeAmount, String purpose, String cycle, LocalDate dueDate, String nickname) {
        this.hopeAmount = hopeAmount;
        this.purpose = purpose;
        this.cycle = cycle;
        this.dueDate = dueDate;
        this.nickname = nickname;
    }

    public static GetGoalResponseDTO fromEntity(GoalEntity goalEntity) {
        LocalDate dueDate = goalEntity.getDueDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return new GetGoalResponseDTO(
                goalEntity.getHopeAmount(),
                goalEntity.getPurpose(),
                goalEntity.getCycle(),
                dueDate,
                goalEntity.getUser().getNickname()
        );
    }

    public Integer getHopeAmount() {
        return hopeAmount;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getCycle() {
        return cycle;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getNickname() {
        return nickname;
    }
}

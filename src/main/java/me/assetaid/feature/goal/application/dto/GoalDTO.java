package me.assetaid.feature.goal.application.dto;

import me.assetaid.feature.goal.repository.entity.GoalEntity;

import java.util.Date;

public record GoalDTO(
        Long goal_id,
        String user_id,
        String goal_type,
        String purpose,
        Integer hope_amount,
        Date due_date,
        String cycle
) {
    public static GoalDTO fromEntity(GoalEntity entity) {
        return new GoalDTO(
                entity.getGoalId(),
                entity.getUser().getUserId(),
                entity.getGoalType(),
                entity.getPurpose(),
                entity.getHopeAmount(),
                entity.getDueDate(),
                entity.getCycle()
        );
    }
}

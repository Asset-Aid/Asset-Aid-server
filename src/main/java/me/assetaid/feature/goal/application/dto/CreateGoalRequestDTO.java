package me.assetaid.feature.goal.application.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Date;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record CreateGoalRequestDTO(
        String userId,
        String goalType,
        String purpose,
        Integer hopeAmount,
        Date dueDate,
        String cycle
) {
}

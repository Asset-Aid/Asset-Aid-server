package me.assetaid.preference.application.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import me.assetaid.preference.repository.entity.PreferenceEntity;

import java.util.UUID;

public record PreferenceDTO(
        UUID preference_id,
        UUID user_id,
        Integer available_amount,
        Integer debt,
        Integer salary,
        Integer spend,
        String investment_style,
        String job,
        String knowledge_level
) {
    public static PreferenceDTO fromEntity(PreferenceEntity entity) {
        return new PreferenceDTO(
                entity.getPreferenceId(),
                entity.getUser().getUserId(),
                entity.getAvailableAmount(),
                entity.getDebt(),
                entity.getSalary(),
                entity.getSpend(),
                entity.getInvestmentStyle(),
                entity.getJob(),
                entity.getKnowledgeLevel()
        );
    }
}

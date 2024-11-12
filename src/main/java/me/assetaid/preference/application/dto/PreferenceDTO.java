package me.assetaid.preference.application.dto;

import me.assetaid.preference.repository.entity.PreferenceEntity;

public record PreferenceDTO(
        Integer preference_id,
        String user_id,
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

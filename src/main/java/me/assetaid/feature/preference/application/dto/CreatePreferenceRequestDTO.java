package me.assetaid.feature.preference.application.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record CreatePreferenceRequestDTO(
        String userId,
        Integer availableAmount,
        Integer debt,
        Integer salary,
        Integer spend,
        String investmentStyle,
        String job,
        String knowledgeLevel,
        List<Integer> bankId
) {
}

package me.assetaid.feature.goal.application.dto;

public class GoalCountDTO {
    private final long shortTermCount;
    private final long longTermCount;

    public GoalCountDTO(long shortTermCount, long longTermCount) {
        this.shortTermCount = shortTermCount;
        this.longTermCount = longTermCount;
    }

    public long getShortTermCount() {
        return shortTermCount;
    }

    public long getLongTermCount() {
        return longTermCount;
    }
}

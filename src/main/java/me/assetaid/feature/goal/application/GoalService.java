package me.assetaid.feature.goal.application;

import me.assetaid.feature.goal.application.dto.CommonIdResponseDto;
import me.assetaid.feature.goal.application.dto.CreateGoalRequestDTO;
import me.assetaid.feature.goal.application.dto.GetGoalResponseDTO;
import me.assetaid.feature.goal.application.dto.GoalCountDTO;
import me.assetaid.feature.goal.repository.GoalRepository;
import me.assetaid.feature.goal.repository.entity.GoalEntity;
import me.assetaid.element.user.application.UserService;
import me.assetaid.element.user.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GoalService {

    private final GoalRepository goalRepository;
    private final UserService userService;

    // 목표 정보 작성
    @Transactional
    public CommonIdResponseDto createGoal(CreateGoalRequestDTO dto) {
        Assert.notNull(dto.userId(), "User ID cannot be null");
        UserEntity user = userService.getUserById(dto.userId());
        GoalEntity goal = new GoalEntity(
                dto.goalType(),
                dto.purpose(),
                dto.hopeAmount(),
                dto.dueDate(),
                dto.cycle(),
                user
        );

        GoalEntity savedGoal = goalRepository.save(goal);
        return new CommonIdResponseDto(savedGoal.getGoalId());
    }

    // 목표 정보 조회
    @Transactional(readOnly = true)
    public Optional<GetGoalResponseDTO> getGoalById(Long goalId) {
        return goalRepository.findById(goalId)
                .map(GetGoalResponseDTO::fromEntity);
    }
    // 목표 개수 조회
    @Transactional(readOnly = true)
    public GoalCountDTO countGoalsByType() {
        long shortTermCount = goalRepository.countByShortTermGoals();
        long longTermCount = goalRepository.countByLongTermGoals();

        return new GoalCountDTO(shortTermCount, longTermCount);
    }
}

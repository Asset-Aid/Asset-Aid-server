package me.assetaid.feature.goal.application;

import me.assetaid.feature.goal.application.dto.CommonIdResponseDto;
import me.assetaid.feature.goal.application.dto.CreateGoalRequestDTO;
import me.assetaid.feature.goal.application.dto.GetGoalResponseDTO;
import me.assetaid.feature.goal.application.dto.GoalCountDTO;
import me.assetaid.feature.goal.repository.GoalRepository;
import me.assetaid.feature.goal.repository.entity.GoalEntity;
import me.assetaid.element.user.application.UserService;
import me.assetaid.element.user.repository.entity.UserEntity;
import me.assetaid.feature.notification.application.NotificationService;  // NotificationService import
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
    private final NotificationService notificationService;  // NotificationService 주입

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

        // 목표 생성 후 알림을 생성하고 발송 처리
        notificationService.createNotificationForGoal(savedGoal);  // 알림 생성 및 발송

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



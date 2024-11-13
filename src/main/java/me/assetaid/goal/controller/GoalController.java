package me.assetaid.goal.controller;

import me.assetaid.goal.application.dto.CommonIdResponseDto;
import me.assetaid.goal.application.dto.CreateGoalRequestDTO;
import me.assetaid.goal.application.dto.GetGoalResponseDTO;
import me.assetaid.goal.application.GoalService;
import me.assetaid.goal.application.dto.GoalCountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("preference/goal")
public class GoalController {

    private final GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    // 목표 정보 작성
    @PostMapping("/check")
    public ResponseEntity<CommonIdResponseDto> createGoal(@RequestBody CreateGoalRequestDTO dto) {
        CommonIdResponseDto response = goalService.createGoal(dto);
        return ResponseEntity.ok(response);
    }

    // 목표 요약 정보 조회
    @GetMapping("/summary/{goalId}")
    public ResponseEntity<GetGoalResponseDTO> getGoalById(@PathVariable Long goalId) {
        Optional<GetGoalResponseDTO> goalResponse = goalService.getGoalById(goalId);
        return goalResponse.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    // 목표 개수 조회
    @GetMapping("/count")
    public ResponseEntity<GoalCountDTO> countGoalsByType() {
        GoalCountDTO goalCount = goalService.countGoalsByType();
        return ResponseEntity.ok(goalCount);
    }
}

package me.assetaid.goal.repository;

import me.assetaid.goal.repository.entity.GoalEntity;
import me.assetaid.user.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GoalRepository extends JpaRepository<GoalEntity, Long> {
    Optional<GoalEntity> findByUser(UserEntity user);
    @Query("SELECT COUNT(g) FROM GoalEntity g WHERE g.goalType = 'short'")
    long countByShortTermGoals();

    @Query("SELECT COUNT(g) FROM GoalEntity g WHERE g.goalType = 'long'")
    long countByLongTermGoals();
}

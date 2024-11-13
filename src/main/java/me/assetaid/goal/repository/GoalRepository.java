package me.assetaid.goal.repository;

import me.assetaid.goal.repository.entity.GoalEntity;
import me.assetaid.user.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GoalRepository extends JpaRepository<GoalEntity, Long> {
    Optional<GoalEntity> findByUser(UserEntity user);
}

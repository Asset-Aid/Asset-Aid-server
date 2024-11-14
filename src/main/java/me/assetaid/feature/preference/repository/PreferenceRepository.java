package me.assetaid.feature.preference.repository;

import me.assetaid.feature.preference.repository.entity.PreferenceEntity;
import me.assetaid.element.user.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PreferenceRepository extends JpaRepository<PreferenceEntity,Long> {
    Optional<PreferenceEntity> findByUser(UserEntity user);
    @Query("SELECT p FROM PreferenceEntity p JOIN p.user u WHERE u.userId = :userId")
    Optional<PreferenceEntity> findByUserId(String userId);
}

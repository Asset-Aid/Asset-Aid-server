package me.assetaid.feature.preference.repository;

import me.assetaid.feature.preference.repository.entity.PreferenceEntity;
import me.assetaid.element.user.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PreferenceRepository extends JpaRepository<PreferenceEntity,Long> {
    Optional<PreferenceEntity> findByUser(UserEntity user);
    Optional<PreferenceEntity> findByUserId(String userId);
}

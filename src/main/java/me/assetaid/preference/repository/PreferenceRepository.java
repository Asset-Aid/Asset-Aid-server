package me.assetaid.preference.repository;

import me.assetaid.preference.repository.entity.PreferenceEntity;
import me.assetaid.user.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PreferenceRepository extends JpaRepository<PreferenceEntity,UUID> {
    Optional<PreferenceEntity> findByUser(UserEntity user);
}

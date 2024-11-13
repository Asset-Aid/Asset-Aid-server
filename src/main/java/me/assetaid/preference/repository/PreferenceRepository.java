package me.assetaid.preference.repository;

import me.assetaid.preference.repository.entity.PreferenceEntity;
import me.assetaid.user.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PreferenceRepository extends JpaRepository<PreferenceEntity,Long> {
    Optional<PreferenceEntity> findByUser(UserEntity user);
}

package me.assetaid.feature.notification.repository;

import me.assetaid.feature.notification.repository.entity.NotificationLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<NotificationLogEntity, Integer> {
    List<NotificationLogEntity> findByUserId(String userId);
}



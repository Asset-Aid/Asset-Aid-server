package me.assetaid.feature.notification.repository;

import me.assetaid.feature.notification.repository.entity.NotificationLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<NotificationLogEntity, Long> {
}







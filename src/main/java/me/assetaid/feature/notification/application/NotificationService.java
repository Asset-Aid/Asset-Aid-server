package me.assetaid.feature.notification.application;

import lombok.RequiredArgsConstructor;
import me.assetaid.feature.notification.application.dto.CreateNotificationRequestDTO;
import me.assetaid.feature.notification.application.dto.NotificationResponseDTO;
import me.assetaid.feature.notification.repository.NotificationRepository;
import me.assetaid.feature.notification.repository.entity.NotificationLogEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationResponseDTO createNotification(CreateNotificationRequestDTO dto) {
        NotificationLogEntity notification = new NotificationLogEntity();
        notification.setUserId(dto.getUserId());
        notification.setGoalId(dto.getGoalId());

        NotificationLogEntity savedNotification = notificationRepository.save(notification);

        return new NotificationResponseDTO(
                savedNotification.getId(),
                savedNotification.getUserId(),
                savedNotification.getGoalId(),
                savedNotification.getCreatedAt()
        );
    }

    public List<NotificationResponseDTO> getNotificationsByUserId(String userId) {
        List<NotificationLogEntity> notifications = notificationRepository.findByUserId(userId);

        return notifications.stream()
                .map(notification -> new NotificationResponseDTO(
                        notification.getId(),
                        notification.getUserId(),
                        notification.getGoalId(),
                        notification.getCreatedAt()
                ))
                .collect(Collectors.toList());
    }
}


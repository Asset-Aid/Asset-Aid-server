package me.assetaid.feature.notification.application;

import lombok.RequiredArgsConstructor;
import me.assetaid.feature.notification.repository.NotificationRepository;
import me.assetaid.feature.notification.repository.entity.NotificationLogEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    // 알람 생성
    public NotificationLogEntity createNotification(String userId, Long goalId, String cycle) {
        NotificationLogEntity notification = new NotificationLogEntity();
        notification.setUserId(userId);
        notification.setGoalId(goalId);
        notification.setCycle(cycle);
        notification.setCreatedAt(LocalDateTime.now());

        return notificationRepository.save(notification);
    }

    // 특정 날짜 기준으로 알람 체크 및 발송
    @Scheduled(cron = "0 0 8 * * *") // 매일 오전 8시 실행
    public void sendNotifications() {
        LocalDate today = LocalDate.now();

        List<NotificationLogEntity> dueNotifications = notificationRepository.findAll()
                .stream()
                .filter(notification -> isNotificationDue(notification, today))
                .collect(Collectors.toList());

        dueNotifications.forEach(notification -> {
            notification.setCreatedAt(today.atStartOfDay()); // LocalDate -> LocalDateTime 변환
            notificationRepository.save(notification);
            sendNotification(notification);
        });
    }

    // 알람 주기(cycle) 체크
    private boolean isNotificationDue(NotificationLogEntity notification, LocalDate today) {
        String cycle = notification.getCycle();
        LocalDateTime lastSent = notification.getCreatedAt();

        if (cycle.equalsIgnoreCase("WEEKLY")) {
            return lastSent.plusWeeks(1).toLocalDate().equals(today);
        } else if (cycle.equalsIgnoreCase("MONTHLY")) {
            return lastSent.plusMonths(1).toLocalDate().equals(today);
        }
        return false;
    }

    // 알람 발송 (임시 메서드)
    private void sendNotification(NotificationLogEntity notification) {
        System.out.println("Sending notification to user: " + notification.getUserId() +
                " for goal: " + notification.getGoalId());
        // 실제 알림 발송 로직은 여기서 구현
    }
}

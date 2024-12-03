package me.assetaid.feature.notification.application;

import lombok.RequiredArgsConstructor;
import me.assetaid.entity.NotificationEntity;
import me.assetaid.feature.goal.repository.entity.GoalEntity;
import me.assetaid.feature.notification.repository.NotificationRepository;
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
    private final WebPushService webPushService;

    // 알람 생성
    public NotificationEntity createNotification(String userId, long goalId, String cycle) {
        NotificationEntity notification = new NotificationEntity();
        notification.setUserId(userId);
        notification.setGoalId(goalId);
        notification.setCycle(cycle);
        notification.setCreatedAt(LocalDateTime.now());  // LocalDateTime 사용

        return notificationRepository.save(notification);
    }

    // GoalEntity에서 알림 생성 (goalId가 Long 타입으로 처리)
    public void createNotificationForGoal(GoalEntity goal) {
        // GoalEntity에서 사용자 ID, 목표 ID, 주기 정보 추출
        String userId = goal.getUser().getId();
        Long goalId = goal.getGoalId();  // goalId를 Long으로 처리
        String cycle = goal.getCycle();  // 주기 정보(WEEKLY, MONTHLY 등)

        // 알림 생성 메소드 호출
        createNotification(userId, goalId, cycle);
    }

    // 특정 날짜 기준으로 알람 체크 및 발송
    @Scheduled(cron = "0 0 8 * * *") // 매일 오전 8시 실행
    public void sendNotifications() {
        LocalDate today = LocalDate.now();

        List<NotificationEntity> dueNotifications = notificationRepository.findAll()
                .stream()
                .filter(notification -> isNotificationDue(notification, today))
                .collect(Collectors.toList());

        dueNotifications.forEach(notification -> {
            notification.setCreatedAt(today.atStartOfDay()); // LocalDate -> LocalDateTime 변환
            notificationRepository.save(notification);
            sendPushNotification(notification);
        });
    }

    // 알람 주기(cycle) 체크
    private boolean isNotificationDue(NotificationEntity notification, LocalDate today) {
        String cycle = notification.getCycle();
        LocalDateTime lastSent = notification.getCreatedAt();

        if (cycle.equalsIgnoreCase("WEEKLY")) {
            return lastSent.plusWeeks(1).toLocalDate().equals(today);
        } else if (cycle.equalsIgnoreCase("MONTHLY")) {
            return lastSent.plusMonths(1).toLocalDate().equals(today);
        }
        return false;
    }

    // 웹 푸시 알림 발송
    private void sendPushNotification(NotificationEntity notification) {
        String userId = notification.getUserId();
        Long goalId = notification.getGoalId();
        String cycle = notification.getCycle();

        // 푸시 알림을 실제로 보내는 메서드 호출
        webPushService.sendPushNotification(userId, "Goal Reminder",
                "Your goal is due soon! (Cycle: " + cycle + ")", goalId);
    }
}

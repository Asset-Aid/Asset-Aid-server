package me.assetaid.feature.notification.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebPushService {

    // 푸시 서버의 API 키나 URL 등의 정보 (실제 서비스에 맞게 설정)
    @Value("${push.service.apiKey}")
    private String apiKey;

    @Value("${push.service.url}")
    private String serviceUrl;

    private final RestTemplate restTemplate;

    public WebPushService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // 웹 푸시 알림 발송 메서드
    public void sendPushNotification(String userId, String title, String message, String goalId) {
        // 푸시 알림을 발송할 URL 및 메시지 형식 설정
        String pushPayload = buildPushPayload(userId, title, message, goalId);

        // Web Push Protocol을 통해 알림 발송
        sendToWebPushServer(pushPayload);
    }

    private String buildPushPayload(String userId, String title, String message, String goalId) {
        // 여기에 Web Push Protocol에 맞는 페이로드 구성을 추가 (예: FCM 또는 다른 서비스의 형식에 맞춰서)
        // 예시로는 JSON 형식의 페이로드를 사용하였으므로 실제 API에 맞는 형식으로 변환해야 합니다.
        return "{"
                + "\"to\": \"" + userId + "\", "
                + "\"notification\": {"
                + "\"title\": \"" + title + "\", "
                + "\"body\": \"" + message + "\", "
                + "\"goalId\": \"" + goalId + "\""
                + "}}";
    }

    private void sendToWebPushServer(String pushPayload) {
        // 실제 푸시 알림을 전송하는 로직 구현
        // Firebase Cloud Messaging, 또는 다른 Web Push 서비스를 사용할 수 있습니다.

        try {
            // API 요청 예시 (실제 API에 맞게 수정)
            restTemplate.postForObject(serviceUrl, pushPayload, String.class);
        } catch (Exception e) {
            e.printStackTrace();
            // 오류 처리 로직 추가 (알림 전송 실패 시 처리)
        }
    }
}

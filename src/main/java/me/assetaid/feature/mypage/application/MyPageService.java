package me.assetaid.feature.mypage.application;

import me.assetaid.feature.mypage.application.dto.GetMyInfoResponseDTO;
import me.assetaid.element.user.repository.UserRepository;
import me.assetaid.element.user.repository.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyPageService {

    private final UserRepository userRepository;

    @Autowired
    public MyPageService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public GetMyInfoResponseDTO getUserProfile(String userId) {
        return userRepository.findById(userId)
                .map(user -> new GetMyInfoResponseDTO(
                        user.getUserId(),
                        user.getId(),
                        user.getNickname()
                ))
                .orElse(null);
    }
}

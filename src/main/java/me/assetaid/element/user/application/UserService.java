package me.assetaid.element.user.application;

import me.assetaid.element.user.repository.UserRepository;
import me.assetaid.element.user.repository.entity.UserEntity;
import me.assetaid.common.exception.CommonException;
import me.assetaid.common.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    public UserEntity getUserById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_USER));
    }

    public UserEntity findByUserId(String userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_USER));
    }

    @Transactional
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Transactional
    public UserEntity updateUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Transactional
    public void deleteUser(String userId) {
        UserEntity user = getUserById(userId);
        userRepository.delete(user);
    }
}

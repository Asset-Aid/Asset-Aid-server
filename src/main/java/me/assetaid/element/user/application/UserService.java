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

    /**
     * userId로 사용자 조회
     * @param userId 사용자 ID
     * @return UserEntity (사용자 정보)
     */
    public UserEntity getUserById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_USER));
    }

    /**
     * userId로 사용자 조회 (추가 메서드)
     * @param userId 사용자 ID
     * @return UserEntity (사용자 정보)
     */
    public UserEntity findByUserId(String userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_USER));
    }

    /**
     * 새로운 사용자 생성
     * @param user 생성할 사용자 정보
     * @return 생성된 UserEntity
     */
    @Transactional
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    /**
     * 사용자 정보 업데이트
     * @param user 업데이트할 사용자 정보
     * @return 업데이트된 UserEntity
     */
    @Transactional
    public UserEntity updateUser(UserEntity user) {
        return userRepository.save(user);
    }

    /**
     * 사용자 삭제
     * @param userId 삭제할 사용자 ID
     */
    @Transactional
    public void deleteUser(String userId) {
        UserEntity user = getUserById(userId);
        userRepository.delete(user);
    }
}

package me.assetaid.feature.auth.repository;

import me.assetaid.feature.auth.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // userId로 사용자를 찾는 메소드 (Optional로 수정)
    Optional<UserEntity> findByUserId(String userId);

    // userId 중복 체크
    boolean existsByUserId(String userId);
}

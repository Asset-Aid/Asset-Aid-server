package me.assetaid.user.repository;

import me.assetaid.user.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity,String> {
    Optional<UserEntity> findByUserId(String userId);
}

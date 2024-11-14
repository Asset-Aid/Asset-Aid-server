package me.assetaid.element.user.repository;

import me.assetaid.element.user.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,String> {
    Optional<UserEntity> findByUserId(String userId);
}

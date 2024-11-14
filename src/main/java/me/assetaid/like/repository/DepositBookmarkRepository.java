package me.assetaid.like.repository;

import me.assetaid.like.repository.entity.DepositBookmarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface DepositBookmarkRepository extends JpaRepository<DepositBookmarkEntity, Integer> {
    List<DepositBookmarkEntity> findByUserId(String userId);
    Optional<DepositBookmarkEntity> findByUserIdAndDepositDepositId(String userId, Integer depositId);
}

package me.assetaid.feature.like.repository;

import me.assetaid.feature.like.repository.entity.SavingBookmarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SavingBookmarkRepository extends JpaRepository<SavingBookmarkEntity, Integer> {
    List<SavingBookmarkEntity> findByUserId(String userId);
    Optional<SavingBookmarkEntity> findByUserIdAndSavingSavingId(String userId, Integer savingId);
}

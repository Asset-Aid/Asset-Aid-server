package me.assetaid.like.repository;

import me.assetaid.like.repository.entity.SavingBookmarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavingBookmarkRepository extends JpaRepository<SavingBookmarkEntity, Integer> {
    List<SavingBookmarkEntity> findByUserId(String userId);
}

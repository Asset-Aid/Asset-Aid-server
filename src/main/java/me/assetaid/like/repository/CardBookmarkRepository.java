package me.assetaid.like.repository;

import me.assetaid.like.repository.entity.CardBookmarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardBookmarkRepository extends JpaRepository<CardBookmarkEntity, Integer> {
    List<CardBookmarkEntity> findByUserId(String userId);
    Optional<CardBookmarkEntity> findByUserIdAndCardCardId(String userId, Integer cardId);
}

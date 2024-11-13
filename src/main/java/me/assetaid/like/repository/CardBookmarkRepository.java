package me.assetaid.like.repository;

import me.assetaid.like.repository.entity.CardBookmarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardBookmarkRepository extends JpaRepository<CardBookmarkEntity, Integer> {
    List<CardBookmarkEntity> findByUserId(String userId);
}

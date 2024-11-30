package me.assetaid.feature.search.card.repository;

import me.assetaid.feature.search.card.repository.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CardSearchRepository extends JpaRepository<CardEntity, Long> {

    // 혜택 검색을 위한 JPQL 쿼리
    @Query("SELECT c FROM CardEntity c WHERE c.benefits LIKE %:keyword%")
    List<CardEntity> findByBenefitsContaining(@Param("keyword") String keyword);

    // 전체 카드 가져오기 (JpaRepository 기본 제공)
}


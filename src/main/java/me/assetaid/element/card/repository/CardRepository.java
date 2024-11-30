package me.assetaid.element.card.repository;

import me.assetaid.element.card.repository.entity.CardEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<CardEntity,Integer> {
    List<CardEntity> findTop3ByOrderByViewCountDesc();
    List<CardEntity> findByBankIdInOrderByViewCountDesc(List<Integer> bankIds, Pageable pageable);
}

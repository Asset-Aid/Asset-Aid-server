package me.assetaid.element.card.repository;

import me.assetaid.element.card.repository.entity.CardEntity;
import me.assetaid.element.deposit.repository.entity.DepositEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<CardEntity,Integer> {
    List<CardEntity> findTop3ByOrderByViewCountDesc();
    List<CardEntity> findByBankIdInOrderByViewCountDesc(List<Integer> bankIds, Pageable pageable);
}

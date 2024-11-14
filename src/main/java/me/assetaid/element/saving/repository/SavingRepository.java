package me.assetaid.element.saving.repository;

import me.assetaid.element.saving.repository.entity.SavingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SavingRepository extends JpaRepository<SavingEntity, Integer> {
    List<SavingEntity> findTop3ByOrderByViewCountDesc();
    List<SavingEntity> findByBankIdInOrderByViewCountDesc(List<Integer> bankIds, Pageable pageable);
}

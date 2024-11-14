package me.assetaid.element.saving.repository;

import me.assetaid.element.deposit.repository.entity.DepositEntity;
import me.assetaid.element.saving.repository.entity.SavingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavingRepository extends JpaRepository<SavingEntity,Integer> {
    List<SavingEntity> findTop3ByOrderByViewCountDesc();
}

package me.assetaid.element.deposit.repository;

import me.assetaid.element.deposit.repository.entity.DepositEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepositRepository extends JpaRepository<DepositEntity,Integer> {
    List<DepositEntity> findTop3ByOrderByViewCountDesc();
}

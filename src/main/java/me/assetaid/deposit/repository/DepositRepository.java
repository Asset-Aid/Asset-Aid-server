package me.assetaid.deposit.repository;

import me.assetaid.deposit.repository.entity.DepositEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositRepository extends JpaRepository<DepositEntity,Integer> {
}

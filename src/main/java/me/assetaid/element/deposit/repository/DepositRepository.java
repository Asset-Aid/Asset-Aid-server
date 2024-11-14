package me.assetaid.element.deposit.repository;

import me.assetaid.element.deposit.repository.entity.DepositEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositRepository extends JpaRepository<DepositEntity,Integer> {
}

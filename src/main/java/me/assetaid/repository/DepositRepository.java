package me.assetaid.repository;

import me.assetaid.entity.DepositEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositRepository extends JpaRepository<DepositEntity,Long> {
}

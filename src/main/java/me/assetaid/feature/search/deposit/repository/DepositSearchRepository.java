package me.assetaid.feature.search.deposit.repository;

import me.assetaid.feature.search.deposit.repository.entity.DepositEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepositSearchRepository extends JpaRepository<DepositEntity, Long> {
    @Query("SELECT d FROM DepositEntity d WHERE d.bankName IN :bankNames AND d.savingTerm >= :savingTerm AND d.productName LIKE %:depositType%")
    List<DepositEntity> searchDeposits(List<String> bankNames, String depositType, int savingTerm);
}

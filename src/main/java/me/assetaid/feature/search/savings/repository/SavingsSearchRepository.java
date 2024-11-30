package me.assetaid.feature.search.savings.repository;

import me.assetaid.feature.search.savings.repository.entity.SavingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SavingsSearchRepository extends JpaRepository<SavingsEntity, Long> {

    @Query("SELECT s FROM SavingsEntity s WHERE "
            + "(:bankNames IS NULL OR s.bankName IN :bankNames) AND "
            + "(:savingsType IS NULL OR s.savingsType = :savingsType) AND "
            + "(:minTerm IS NULL OR s.term >= :minTerm) AND "
            + "(:maxTerm IS NULL OR s.term <= :maxTerm) AND "
            + "(:minAmount IS NULL OR s.subscriptionAmount >= :minAmount)")
    List<SavingsEntity> searchSavings(
            @Param("bankNames") List<String> bankNames,
            @Param("savingsType") String savingsType,
            @Param("minTerm") Integer minTerm,
            @Param("maxTerm") Integer maxTerm,
            @Param("minAmount") Double minAmount
    );
}

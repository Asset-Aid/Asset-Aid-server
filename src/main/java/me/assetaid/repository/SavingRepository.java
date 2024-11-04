package me.assetaid.repository;

import me.assetaid.entity.SavingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingRepository extends JpaRepository<SavingEntity,Long> {
}

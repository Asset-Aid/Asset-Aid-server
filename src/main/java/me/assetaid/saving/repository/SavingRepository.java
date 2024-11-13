package me.assetaid.saving.repository;

import me.assetaid.saving.repository.entity.SavingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingRepository extends JpaRepository<SavingEntity,Integer> {
}

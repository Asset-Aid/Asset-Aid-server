package me.assetaid.element.saving.repository;

import me.assetaid.element.saving.repository.entity.SavingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingRepository extends JpaRepository<SavingEntity,Integer> {
}

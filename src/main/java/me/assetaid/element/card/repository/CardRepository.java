package me.assetaid.element.card.repository;

import me.assetaid.element.card.repository.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<CardEntity,Integer> {
}

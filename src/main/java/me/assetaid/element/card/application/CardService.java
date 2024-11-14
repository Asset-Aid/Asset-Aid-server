package me.assetaid.element.card.application;

import me.assetaid.element.card.repository.entity.CardEntity;
import me.assetaid.element.card.repository.CardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Transactional(readOnly = true)
    public CardEntity getCardById(Integer cardId) {
        return cardRepository.findById(cardId)
                .orElseThrow(() -> new IllegalArgumentException("Card not found with ID: " + cardId));
    }
}

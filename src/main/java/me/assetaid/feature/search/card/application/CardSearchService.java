package me.assetaid.feature.search.card.application;

import me.assetaid.feature.search.card.application.dto.CardSearchRequestDTO;
import me.assetaid.feature.search.card.application.dto.CardSearchResponseDTO;
import me.assetaid.feature.search.card.repository.CardSearchRepository;
import me.assetaid.feature.search.card.repository.entity.CardEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CardSearchService {

    private final CardSearchRepository cardSearchRepository;

    public CardSearchService(CardSearchRepository cardSearchRepository) {
        this.cardSearchRepository = cardSearchRepository;
    }

    public List<CardSearchResponseDTO> searchCards(CardSearchRequestDTO requestDTO) {
        List<String> benefits = requestDTO.getBenefits(); // 검색어 리스트
        Set<CardEntity> resultSet = new HashSet<>();

        // 각 검색어에 대해 혜택 검색
        for (String benefit : benefits) {
            List<CardEntity> cards = cardSearchRepository.findByBenefitsContaining(benefit);
            resultSet.addAll(cards); // 중복 제거
        }

        // 결과를 DTO로 변환
        return resultSet.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public List<CardSearchResponseDTO> getAllCards() {
        List<CardEntity> cards = cardSearchRepository.findAll();
        return cards.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    private CardSearchResponseDTO convertToResponseDTO(CardEntity card) {
        return new CardSearchResponseDTO(
                card.getCardId(),
                card.getCardName(),
                card.getBank(),
                card.getBenefits(),
                card.getCardType(),
                card.getAnnualFeeKor(),
                card.getAnnualFeeFor(),
                card.getCardLimit()
        );
    }
}


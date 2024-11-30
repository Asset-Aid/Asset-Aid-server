package me.assetaid.feature.search.card.controller;

import me.assetaid.feature.search.card.application.CardSearchService;
import me.assetaid.feature.search.card.application.dto.CardSearchRequestDTO;
import me.assetaid.feature.search.card.application.dto.CardSearchResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search/card")
public class CardSearchController {

    private final CardSearchService cardSearchService;

    public CardSearchController(CardSearchService cardSearchService) {
        this.cardSearchService = cardSearchService;
    }

    @PostMapping("/filter")
    public List<CardSearchResponseDTO> searchCards(@RequestBody CardSearchRequestDTO requestDTO) {
        return cardSearchService.searchCards(requestDTO);
    }

    @GetMapping("/all")
    public List<CardSearchResponseDTO> getAllCards() {
        return cardSearchService.getAllCards();
    }
}


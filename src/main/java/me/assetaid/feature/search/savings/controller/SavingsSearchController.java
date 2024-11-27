package me.assetaid.feature.search.savings.controller;

import lombok.RequiredArgsConstructor;
import me.assetaid.feature.search.savings.application.SavingsSearchService;
import me.assetaid.feature.search.savings.application.dto.SavingsSearchResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/savings")
@RequiredArgsConstructor
public class SavingsSearchController {

    private final SavingsSearchService savingsSearchService;

    @GetMapping("/search")
    public ResponseEntity<List<SavingsSearchResponseDTO>> searchSavings(
            @RequestParam List<String> bankNames,
            @RequestParam String savingsType,
            @RequestParam Integer minTerm,
            @RequestParam Integer maxTerm,
            @RequestParam Double minAmount
    ) {
        List<SavingsSearchResponseDTO> result = savingsSearchService.searchSavings(bankNames, savingsType, minTerm, maxTerm, minAmount);
        return ResponseEntity.ok(result);
    }
}


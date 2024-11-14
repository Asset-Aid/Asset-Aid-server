package me.assetaid.feature.recommend.controller;

import me.assetaid.feature.recommend.application.RecommendService;
import me.assetaid.feature.recommend.application.dto.GetDepositRecommendDTO;
import me.assetaid.feature.recommend.application.dto.GetCardRecommendDTO;
import me.assetaid.feature.recommend.application.dto.GetSavingRecommendDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommend")
public class RecommendController {

    private final RecommendService recommendService;

    @Autowired
    public RecommendController(RecommendService recommendService) {
        this.recommendService = recommendService;
    }

    @GetMapping("/deposit/{userId}")
    public ResponseEntity<List<GetDepositRecommendDTO>> getTop10Deposits(@PathVariable String userId) {
        List<GetDepositRecommendDTO> topDeposits = recommendService.getTop10DepositsForPreferredBank(userId);
        if (topDeposits.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(topDeposits);
        }
    }

    @GetMapping("/card/{userId}")
    public ResponseEntity<List<GetCardRecommendDTO>> getTop10Cards(@PathVariable String userId) {
        List<GetCardRecommendDTO> topCards = recommendService.getTop10CardsForPreferredBank(userId);
        if (topCards.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(topCards);
        }
    }

    @GetMapping("/saving/{userId}")
    public ResponseEntity<List<GetSavingRecommendDTO>> getTop10Savings(@PathVariable String userId) {
        List<GetSavingRecommendDTO> topSavings = recommendService.getTop10SavingsForPreferredBank(userId);
        if (topSavings.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(topSavings);
        }
    }
}

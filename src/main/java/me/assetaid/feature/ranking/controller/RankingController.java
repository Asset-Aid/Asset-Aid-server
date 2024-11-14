package me.assetaid.feature.ranking.controller;

import me.assetaid.feature.ranking.application.RankingService;
import me.assetaid.feature.ranking.application.dto.GetDepositRankingDTO;
import me.assetaid.feature.ranking.application.dto.GetCardRankingDTO;
import me.assetaid.feature.ranking.application.dto.GetSavingRankingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommend")
public class RankingController {

    private final RankingService rankingService;

    @Autowired
    public RankingController(RankingService rankingService) {
        this.rankingService = rankingService;
    }

    @GetMapping("/chart/deposit")
    public ResponseEntity<List<GetDepositRankingDTO>> getTop3Deposits() {
        List<GetDepositRankingDTO> topDeposits = rankingService.getTop3DepositsByViewCount();
        return ResponseEntity.ok(topDeposits);
    }

    @GetMapping("/chart/card")
    public ResponseEntity<List<GetCardRankingDTO>> getTop3Cards() {
        List<GetCardRankingDTO> topCards = rankingService.getTop3CardsByViewCount();
        return ResponseEntity.ok(topCards);
    }

    @GetMapping("/chart/saving")
    public ResponseEntity<List<GetSavingRankingDTO>> getTop3Savings() {
        List<GetSavingRankingDTO> topSavings = rankingService.getTop3SavingsByViewCount();
        return ResponseEntity.ok(topSavings);
    }
}

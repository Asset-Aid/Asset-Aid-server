package me.assetaid.feature.search.deposit.controller;

import me.assetaid.feature.search.deposit.application.DepositSearchService;
import me.assetaid.feature.search.deposit.application.dto.DepositSearchRequestDTO;
import me.assetaid.feature.search.deposit.application.dto.DepositSearchResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deposits")
public class DepositSearchController {
    private final DepositSearchService depositSearchService;

    public DepositSearchController(DepositSearchService depositSearchService) {
        this.depositSearchService = depositSearchService;
    }

    @PostMapping("/search")
    public List<DepositSearchResponseDTO> searchDeposits(@RequestBody DepositSearchRequestDTO request) {
        return depositSearchService.searchDeposits(request);
    }
}

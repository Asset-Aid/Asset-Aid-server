package me.assetaid.feature.deposit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class DepositController {

    @GetMapping("/search/deposit")
    public ResponseEntity<List<String>> getAllDeposits() {
        List<String> deposits = Arrays.asList("Deposit A", "Deposit B", "Deposit C");
        return ResponseEntity.ok(deposits);
    }
}

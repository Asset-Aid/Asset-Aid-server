package me.assetaid.feature.saving.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class SavingController {

    @GetMapping("/search/savings")
    public ResponseEntity<List<String>> getAllSavings() {
        // Mock 데이터 반환
        List<String> savings = Arrays.asList("Saving A", "Saving B", "Saving C");
        return ResponseEntity.ok(savings);
    }
}

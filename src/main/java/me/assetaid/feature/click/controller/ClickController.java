package me.assetaid.feature.click.controller;

import me.assetaid.feature.click.application.ClickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/view")
public class ClickController {

    private final ClickService clickService;

    @Autowired
    public ClickController(ClickService clickService) {
        this.clickService = clickService;
    }

    @GetMapping("/deposit/{depositId}")
    public ResponseEntity<String> increaseDepositViewCount(@PathVariable Integer depositId) {
        boolean success = clickService.increaseDepositViewCount(depositId);
        if (success) {
            return ResponseEntity.status(200).body("Deposit view count increased successfully.");
        } else {
            return ResponseEntity.status(404).body("Deposit not found.");
        }
    }

    @GetMapping("/card/{cardId}")
    public ResponseEntity<String> increaseCardViewCount(@PathVariable Integer cardId) {
        boolean success = clickService.increaseCardViewCount(cardId);
        if (success) {
            return ResponseEntity.status(200).body("Card view count increased successfully.");
        } else {
            return ResponseEntity.status(404).body("Card not found.");
        }
    }

    @GetMapping("/saving/{savingId}")
    public ResponseEntity<String> increaseSavingViewCount(@PathVariable Integer savingId) {
        boolean success = clickService.increaseSavingViewCount(savingId);
        if (success) {
            return ResponseEntity.status(200).body("Saving view count increased successfully.");
        } else {
            return ResponseEntity.status(404).body("Saving not found.");
        }
    }
}

package me.assetaid.feature.click.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CardController {

    @GetMapping("/search/cards")
    public ResponseEntity<List<String>> getAllCards() {
        List<String> cards = Arrays.asList("Card A", "Card B", "Card C");
        return ResponseEntity.ok(cards);
    }
}

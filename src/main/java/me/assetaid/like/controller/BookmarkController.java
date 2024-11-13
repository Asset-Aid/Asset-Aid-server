package me.assetaid.like.controller;

import me.assetaid.like.application.BookmarkService;
import me.assetaid.like.repository.entity.CardBookmarkEntity;
import me.assetaid.like.repository.entity.DepositBookmarkEntity;
import me.assetaid.like.repository.entity.SavingBookmarkEntity;
import me.assetaid.like.application.dto.CreateBookmarkRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("recommend")
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @Autowired
    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    @PostMapping("/bookmark/cardLike")
    public ResponseEntity<CardBookmarkEntity> createCardBookmark(
            @RequestParam Integer cardId,
            @RequestBody CreateBookmarkRequestDTO dto) {

        CardBookmarkEntity cardBookmark = bookmarkService.createCardBookmark(cardId, dto);
        return ResponseEntity.ok(cardBookmark);
    }

    @PostMapping("/bookmark/depositLike")
    public ResponseEntity<DepositBookmarkEntity> createDepositBookmark(
            @RequestParam Integer depositId,
            @RequestBody CreateBookmarkRequestDTO dto) {

        DepositBookmarkEntity depositBookmark = bookmarkService.createDepositBookmark(depositId, dto);
        return ResponseEntity.ok(depositBookmark);
    }

    @PostMapping("/bookmark/savingLike")
    public ResponseEntity<SavingBookmarkEntity> createSavingBookmark(
            @RequestParam Integer savingId,
            @RequestBody CreateBookmarkRequestDTO dto) {

        SavingBookmarkEntity savingBookmark = bookmarkService.createSavingBookmark(savingId, dto);
        return ResponseEntity.ok(savingBookmark);
    }
}

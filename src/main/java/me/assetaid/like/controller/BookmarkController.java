package me.assetaid.like.controller;

import me.assetaid.like.application.BookmarkService;
import me.assetaid.like.application.dto.BookmarkResponseDTO;
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
    public ResponseEntity<BookmarkResponseDTO> createCardBookmark(
            @RequestParam Integer cardId,
            @RequestBody CreateBookmarkRequestDTO dto) {

        BookmarkResponseDTO response = bookmarkService.createCardBookmark(cardId, dto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/bookmark/depositLike")
    public ResponseEntity<BookmarkResponseDTO> createDepositBookmark(
            @RequestParam Integer depositId,
            @RequestBody CreateBookmarkRequestDTO dto) {

        BookmarkResponseDTO response = bookmarkService.createDepositBookmark(depositId, dto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/bookmark/savingLike")
    public ResponseEntity<BookmarkResponseDTO> createSavingBookmark(
            @RequestParam Integer savingId,
            @RequestBody CreateBookmarkRequestDTO dto) {

        BookmarkResponseDTO response = bookmarkService.createSavingBookmark(savingId, dto);
        return ResponseEntity.ok(response);
    }
}

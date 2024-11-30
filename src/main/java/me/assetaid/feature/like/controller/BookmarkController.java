package me.assetaid.feature.like.controller;

import me.assetaid.feature.like.application.BookmarkService;
import me.assetaid.feature.like.application.dto.BookmarkResponseDTO;
import me.assetaid.feature.like.application.dto.CreateBookmarkRequestDTO;
import me.assetaid.feature.like.application.dto.DeleteBookmarkRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("recommend")
public class BookmarkController {
    private static final Logger logger = LoggerFactory.getLogger(BookmarkController.class);
    private final BookmarkService bookmarkService;

    @Autowired
    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }
    @PostMapping("/bookmark/cardLike")
    public ResponseEntity<BookmarkResponseDTO> createCardBookmark(
            @RequestParam Integer cardId,
            @RequestBody CreateBookmarkRequestDTO dto) {
        logger.info("Received cardId: {}", cardId);
        logger.info("Received userId: {}", dto.getUserId());

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

    @DeleteMapping("/bookmark/cardCancel")
    public ResponseEntity<BookmarkResponseDTO> deleteCardBookmark(
            @RequestParam Integer cardBookmarkId,
            @RequestBody DeleteBookmarkRequestDTO dto) {

        BookmarkResponseDTO response = bookmarkService.deleteCardBookmark(dto,cardBookmarkId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/bookmark/depositCancel")
    public ResponseEntity<BookmarkResponseDTO> deleteDepositBookmark(
            @RequestParam Integer depositBookmarkId,
            @RequestBody DeleteBookmarkRequestDTO dto) {

        BookmarkResponseDTO response = bookmarkService.deleteDepositBookmark(dto,depositBookmarkId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/bookmark/savingCancel")
    public ResponseEntity<BookmarkResponseDTO> deleteSavingBookmark(
            @RequestParam Integer savingBookmarkId,
            @RequestBody DeleteBookmarkRequestDTO dto) {

        BookmarkResponseDTO response = bookmarkService.deleteSavingBookmark(dto,savingBookmarkId);
        return ResponseEntity.ok(response);
    }
}

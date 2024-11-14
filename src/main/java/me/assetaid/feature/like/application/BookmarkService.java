package me.assetaid.feature.like.application;

import me.assetaid.feature.like.application.dto.BookmarkDTO;
import me.assetaid.feature.like.application.dto.BookmarkResponseDTO;
import me.assetaid.feature.like.application.dto.CreateBookmarkRequestDTO;
import me.assetaid.feature.like.application.dto.DeleteBookmarkRequestDTO;
import me.assetaid.feature.like.repository.CardBookmarkRepository;
import me.assetaid.feature.like.repository.DepositBookmarkRepository;
import me.assetaid.feature.like.repository.SavingBookmarkRepository;
import me.assetaid.element.user.repository.entity.UserEntity;
import me.assetaid.element.user.application.UserService;
import me.assetaid.element.card.repository.entity.CardEntity;
import me.assetaid.element.deposit.repository.entity.DepositEntity;
import me.assetaid.element.saving.repository.entity.SavingEntity;
import me.assetaid.element.card.application.CardService;
import me.assetaid.element.deposit.application.DepositService;
import me.assetaid.element.saving.application.SavingService;
import me.assetaid.feature.like.repository.entity.CardBookmarkEntity;
import me.assetaid.feature.like.repository.entity.DepositBookmarkEntity;
import me.assetaid.feature.like.repository.entity.SavingBookmarkEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookmarkService {

    private final CardBookmarkRepository cardBookmarkRepository;
    private final DepositBookmarkRepository depositBookmarkRepository;
    private final SavingBookmarkRepository savingBookmarkRepository;
    private final UserService userService;
    private final CardService cardService;
    private final DepositService depositService;
    private final SavingService savingService;

    @Transactional
    public BookmarkResponseDTO createCardBookmark(Integer cardId, CreateBookmarkRequestDTO dto) {
        UserEntity user = userService.getUserById(dto.getUserId());
        if (user == null) {
            return new BookmarkResponseDTO(false, "User not found with ID: " + dto.getUserId(), null, null, null);
        }

        CardEntity card = cardService.getCardById(cardId);
        if (card == null) {
            return new BookmarkResponseDTO(false, "Card not found with ID: " + cardId, null, null, null);
        }

        CardBookmarkEntity cardBookmark = new CardBookmarkEntity();
        cardBookmark.setUser(user);
        cardBookmark.setCard(card);
        cardBookmarkRepository.save(cardBookmark);

        return new BookmarkResponseDTO(true, "Card bookmark created successfully.", cardBookmark.getCardBookmarkId(), null, null);
    }

    @Transactional
    public BookmarkResponseDTO createDepositBookmark(Integer depositId, CreateBookmarkRequestDTO dto) {
        UserEntity user = userService.getUserById(dto.getUserId());
        if (user == null) {
            return new BookmarkResponseDTO(false, "User not found with ID: " + dto.getUserId(), null, null, null);
        }

        DepositEntity deposit = depositService.getDepositById(depositId);
        if (deposit == null) {
            return new BookmarkResponseDTO(false, "Deposit not found with ID: " + depositId, null, null, null);
        }

        DepositBookmarkEntity depositBookmark = new DepositBookmarkEntity();
        depositBookmark.setUser(user);
        depositBookmark.setDeposit(deposit);
        depositBookmarkRepository.save(depositBookmark);

        return new BookmarkResponseDTO(true, "Deposit bookmark created successfully.", null, depositBookmark.getDepositBookmarkId(), null);
    }

    @Transactional
    public BookmarkResponseDTO createSavingBookmark(Integer savingId, CreateBookmarkRequestDTO dto) {
        UserEntity user = userService.getUserById(dto.getUserId());
        if (user == null) {
            return new BookmarkResponseDTO(false, "User not found with ID: " + dto.getUserId(), null, null, null);
        }

        SavingEntity saving = savingService.getSavingById(savingId);
        if (saving == null) {
            return new BookmarkResponseDTO(false, "Saving not found with ID: " + savingId, null, null, null);
        }

        SavingBookmarkEntity savingBookmark = new SavingBookmarkEntity();
        savingBookmark.setUser(user);
        savingBookmark.setSaving(saving);
        savingBookmarkRepository.save(savingBookmark);

        return new BookmarkResponseDTO(true, "Saving bookmark created successfully.", null, null, savingBookmark.getSavingBookmarkId());
    }

    @Transactional
    public BookmarkResponseDTO deleteCardBookmark(DeleteBookmarkRequestDTO dto, Integer cardBookmarkId) {
        UserEntity user = userService.getUserById(dto.getUserId());
        if (user == null) {
            return new BookmarkResponseDTO(false, "User not found with ID: " + dto.getUserId(), null, null, null);
        }

        Optional<CardBookmarkEntity> bookmark = cardBookmarkRepository.findById(cardBookmarkId);
        if (bookmark.isPresent()) {
            cardBookmarkRepository.delete(bookmark.get());
            return new BookmarkResponseDTO(true, "Card bookmark deleted successfully.", cardBookmarkId, null, null);
        }
        return new BookmarkResponseDTO(false, "Card bookmark not found.", null, null, null);
    }

    @Transactional
    public BookmarkResponseDTO deleteDepositBookmark(DeleteBookmarkRequestDTO dto, Integer depositBookmarkId) {
        UserEntity user = userService.getUserById(dto.getUserId());
        if (user == null) {
            return new BookmarkResponseDTO(false, "User not found with ID: " + dto.getUserId(), null, null, null);
        }

        Optional<DepositBookmarkEntity> bookmark = depositBookmarkRepository.findById(depositBookmarkId);
        if (bookmark.isPresent()) {
            depositBookmarkRepository.delete(bookmark.get());
            return new BookmarkResponseDTO(true, "Deposit bookmark deleted successfully.", null, depositBookmarkId, null);
        }
        return new BookmarkResponseDTO(false, "Deposit bookmark not found.", null, null, null);
    }

    @Transactional
    public BookmarkResponseDTO deleteSavingBookmark(DeleteBookmarkRequestDTO dto, Integer savingBookmarkId) {
        UserEntity user = userService.getUserById(dto.getUserId());
        if (user == null) {
            return new BookmarkResponseDTO(false, "User not found with ID: " + dto.getUserId(), null, null, null);
        }

        Optional<SavingBookmarkEntity> bookmark = savingBookmarkRepository.findById(savingBookmarkId);
        if (bookmark.isPresent()) {
            savingBookmarkRepository.delete(bookmark.get());
            return new BookmarkResponseDTO(true, "Saving bookmark deleted successfully.", null, null, savingBookmarkId);
        }
        return new BookmarkResponseDTO(false, "Saving bookmark not found.", null, null, null);
    }

    public List<BookmarkDTO> getCardBookmarksForUser(String userId) {
        List<CardBookmarkEntity> bookmarks = cardBookmarkRepository.findByUserId(userId);

        return bookmarks.stream()
                .map(bookmark -> new BookmarkDTO(
                        bookmark.getCardBookmarkId(),
                        bookmark.getUser().getUserId(),
                        bookmark.getUser().getNickname()
                ))
                .collect(Collectors.toList());
    }

    public List<BookmarkDTO> getDepositBookmarksForUser(String userId) {
        List<DepositBookmarkEntity> bookmarks = depositBookmarkRepository.findByUserId(userId);

        return bookmarks.stream()
                .map(bookmark -> new BookmarkDTO(
                        bookmark.getDepositBookmarkId(),
                        bookmark.getUser().getUserId(),
                        bookmark.getUser().getNickname()
                ))
                .collect(Collectors.toList());
    }

    public List<BookmarkDTO> getSavingBookmarksForUser(String userId) {
        List<SavingBookmarkEntity> bookmarks = savingBookmarkRepository.findByUserId(userId);

        return bookmarks.stream()
                .map(bookmark -> new BookmarkDTO(
                        bookmark.getSavingBookmarkId(),
                        bookmark.getUser().getUserId(),
                        bookmark.getUser().getNickname()
                ))
                .collect(Collectors.toList());
    }
}

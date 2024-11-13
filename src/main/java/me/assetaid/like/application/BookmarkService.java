package me.assetaid.like.application;

import me.assetaid.like.application.dto.BookmarkDTO;
import me.assetaid.like.application.dto.CreateBookmarkRequestDTO;
import me.assetaid.like.repository.CardBookmarkRepository;
import me.assetaid.like.repository.DepositBookmarkRepository;
import me.assetaid.like.repository.SavingBookmarkRepository;
import me.assetaid.user.repository.entity.UserEntity;
import me.assetaid.user.application.UserService;
import me.assetaid.card.repository.entity.CardEntity;
import me.assetaid.deposit.repository.entity.DepositEntity;
import me.assetaid.saving.repository.entity.SavingEntity;
import me.assetaid.card.application.CardService;
import me.assetaid.deposit.application.DepositService;
import me.assetaid.saving.application.SavingService;
import me.assetaid.like.repository.entity.CardBookmarkEntity;
import me.assetaid.like.repository.entity.DepositBookmarkEntity;
import me.assetaid.like.repository.entity.SavingBookmarkEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
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
    public CardBookmarkEntity createCardBookmark(Integer cardId, CreateBookmarkRequestDTO dto) {
        UserEntity user = userService.getUserById(dto.getUserId());
        if (user == null) {
            throw new IllegalArgumentException("User not found with ID: " + dto.getUserId());
        }

        CardEntity card = cardService.getCardById(cardId);
        CardBookmarkEntity cardBookmark = new CardBookmarkEntity();
        cardBookmark.setUser(user);
        cardBookmark.setCard(card);

        return cardBookmarkRepository.save(cardBookmark);
    }

    @Transactional
    public DepositBookmarkEntity createDepositBookmark(Integer depositId, CreateBookmarkRequestDTO dto) {
        UserEntity user = userService.getUserById(dto.getUserId());
        if (user == null) {
            throw new IllegalArgumentException("User not found with ID: " + dto.getUserId());
        }

        DepositEntity deposit = depositService.getDepositById(depositId);
        DepositBookmarkEntity depositBookmark = new DepositBookmarkEntity();
        depositBookmark.setUser(user);
        depositBookmark.setDeposit(deposit);

        return depositBookmarkRepository.save(depositBookmark);
    }

    @Transactional
    public SavingBookmarkEntity createSavingBookmark(Integer savingId, CreateBookmarkRequestDTO dto) {
        UserEntity user = userService.getUserById(dto.getUserId());
        if (user == null) {
            throw new IllegalArgumentException("User not found with ID: " + dto.getUserId());
        }

        SavingEntity saving = savingService.getSavingById(savingId);
        SavingBookmarkEntity savingBookmark = new SavingBookmarkEntity();
        savingBookmark.setUser(user);
        savingBookmark.setSaving(saving);

        return savingBookmarkRepository.save(savingBookmark);
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

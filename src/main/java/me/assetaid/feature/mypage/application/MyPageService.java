package me.assetaid.feature.mypage.application;

import me.assetaid.feature.like.repository.entity.CardBookmarkEntity;
import me.assetaid.feature.like.repository.entity.DepositBookmarkEntity;
import me.assetaid.feature.like.repository.entity.SavingBookmarkEntity;
import me.assetaid.feature.mypage.application.dto.GetCardLikeInfoResponseDTO;
import me.assetaid.feature.mypage.application.dto.GetDepositLikeInfoResponseDTO;
import me.assetaid.feature.mypage.application.dto.GetSavingLikeInfoResponseDTO;
import me.assetaid.feature.mypage.application.dto.GetMyInfoResponseDTO;
import me.assetaid.element.user.repository.UserRepository;
import me.assetaid.element.user.repository.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MyPageService {

    private final UserRepository userRepository;

    @Autowired
    public MyPageService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public GetMyInfoResponseDTO getUserProfile(String userId) {
        return userRepository.findById(userId)
                .map(user -> new GetMyInfoResponseDTO(
                        user.getUserId(),
                        user.getId(),
                        user.getNickname()
                ))
                .orElse(null);
    }

    public GetCardLikeInfoResponseDTO getCardBookmarks(String userId) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(userId);

        if (userEntityOptional.isPresent()) {
            UserEntity user = userEntityOptional.get();

            List<GetCardLikeInfoResponseDTO.CardBookmarkDTO> bookmarks = user.getCardBookmarks().stream()
                    .map(cardBookmark -> {
                        CardBookmarkEntity bookmarkEntity = cardBookmark;
                        return new GetCardLikeInfoResponseDTO.CardBookmarkDTO(
                                bookmarkEntity.getCard().getCardId(),
                                bookmarkEntity.getCard().getBank(),
                                bookmarkEntity.getCard().getCardName(),
                                bookmarkEntity.getCard().getBenefit()
                        );
                    })
                    .collect(Collectors.toList());

            return new GetCardLikeInfoResponseDTO(bookmarks);
        } else {
            return new GetCardLikeInfoResponseDTO(List.of());
        }
    }

    public GetDepositLikeInfoResponseDTO getDepositBookmarks(String userId) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(userId);

        if (userEntityOptional.isPresent()) {
            UserEntity user = userEntityOptional.get();

            List<GetDepositLikeInfoResponseDTO.DepositBookmarkDTO> bookmarks = user.getDepositBookmarks().stream()
                    .map(depositBookmark -> {
                        DepositBookmarkEntity bookmarkEntity = depositBookmark;
                        return new GetDepositLikeInfoResponseDTO.DepositBookmarkDTO(
                                bookmarkEntity.getDeposit().getDepositId(),
                                bookmarkEntity.getDeposit().getBank(),
                                bookmarkEntity.getDeposit().getDepositName(),
                                bookmarkEntity.getDeposit().getContents()
                        );
                    })
                    .collect(Collectors.toList());

            return new GetDepositLikeInfoResponseDTO(bookmarks);
        } else {
            return new GetDepositLikeInfoResponseDTO(List.of());
        }
    }

    public GetSavingLikeInfoResponseDTO getSavingBookmarks(String userId) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(userId);

        if (userEntityOptional.isPresent()) {
            UserEntity user = userEntityOptional.get();

            List<GetSavingLikeInfoResponseDTO.SavingBookmarkDTO> bookmarks = user.getSavingBookmarks().stream()
                    .map(savingBookmark -> {
                        SavingBookmarkEntity bookmarkEntity = savingBookmark;
                        return new GetSavingLikeInfoResponseDTO.SavingBookmarkDTO(
                                bookmarkEntity.getSaving().getSavingId(),
                                bookmarkEntity.getSaving().getBank(),
                                bookmarkEntity.getSaving().getSavingName(),
                                bookmarkEntity.getSaving().getContents()
                        );
                    })
                    .collect(Collectors.toList());

            return new GetSavingLikeInfoResponseDTO(bookmarks);
        } else {
            return new GetSavingLikeInfoResponseDTO(List.of());
        }
    }
}

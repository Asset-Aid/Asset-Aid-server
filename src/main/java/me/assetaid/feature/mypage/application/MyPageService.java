package me.assetaid.feature.mypage.application;

import me.assetaid.feature.goal.repository.entity.GoalEntity;
import me.assetaid.feature.like.repository.entity.CardBookmarkEntity;
import me.assetaid.feature.like.repository.entity.DepositBookmarkEntity;
import me.assetaid.feature.like.repository.entity.SavingBookmarkEntity;
import me.assetaid.feature.mypage.application.dto.*;
import me.assetaid.feature.preference.repository.entity.PreferenceEntity;
import me.assetaid.element.user.repository.UserRepository;
import me.assetaid.element.user.repository.entity.UserEntity;
import me.assetaid.feature.goal.repository.GoalRepository;
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
                    .map(cardBookmark -> new GetCardLikeInfoResponseDTO.CardBookmarkDTO(
                            cardBookmark.getCard().getCardId(),
                            cardBookmark.getCard().getBank(),
                            cardBookmark.getCard().getCardName(),
                            cardBookmark.getCard().getBenefit()
                    ))
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
                    .map(depositBookmark -> new GetDepositLikeInfoResponseDTO.DepositBookmarkDTO(
                            depositBookmark.getDeposit().getDepositId(),
                            depositBookmark.getDeposit().getBank(),
                            depositBookmark.getDeposit().getDepositName(),
                            depositBookmark.getDeposit().getContents()
                    ))
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
                    .map(savingBookmark -> new GetSavingLikeInfoResponseDTO.SavingBookmarkDTO(
                            savingBookmark.getSaving().getSavingId(),
                            savingBookmark.getSaving().getBank(),
                            savingBookmark.getSaving().getSavingName(),
                            savingBookmark.getSaving().getContents()
                    ))
                    .collect(Collectors.toList());

            return new GetSavingLikeInfoResponseDTO(bookmarks);
        } else {
            return new GetSavingLikeInfoResponseDTO(List.of());
        }
    }
    @Autowired
    private GoalRepository goalRepository;

    public boolean deleteGoal(Integer goalId, String userId) {
        Optional<GoalEntity> goalEntity = goalRepository.findByGoalIdAndUser_UserId(goalId, userId);

        if (goalEntity.isPresent()) {
            goalRepository.delete(goalEntity.get());
            return true;
        }
        return false;
    }

    public GetPreferenceResponseDTO getUserPreference(String userId) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(userId);

        if (userEntityOptional.isPresent()) {
            UserEntity user = userEntityOptional.get();
            PreferenceEntity preference = user.getPreference();

            if (preference != null) {
                return new GetPreferenceResponseDTO(
                        preference.getAvailableAmount(),
                        preference.getBank(),
                        preference.getBankId(),
                        preference.getDebt(),
                        preference.getInvestmentStyle(),
                        preference.getJob(),
                        preference.getKnowledgeLevel(),
                        preference.getSalary(),
                        preference.getSpend(),
                        user.getUserId()
                );
            }
        }
        return null;
    }
}

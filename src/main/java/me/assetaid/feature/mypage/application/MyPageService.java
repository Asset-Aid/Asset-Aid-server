package me.assetaid.feature.mypage.application;

import me.assetaid.feature.like.repository.entity.CardBookmarkEntity;
import me.assetaid.feature.mypage.application.dto.GetCardLikeInfoResponseDTO;
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
    }

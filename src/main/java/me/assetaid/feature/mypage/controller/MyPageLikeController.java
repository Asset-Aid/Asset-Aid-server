package me.assetaid.feature.mypage.controller;

import me.assetaid.feature.mypage.application.MyPageService;
import me.assetaid.feature.mypage.application.dto.GetCardLikeInfoResponseDTO;
import me.assetaid.feature.mypage.application.dto.GetDepositLikeInfoResponseDTO;
import me.assetaid.feature.mypage.application.dto.GetSavingLikeInfoResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mypage/bookmark")
public class MyPageLikeController {

    private final MyPageService myPageService;

    public MyPageLikeController(MyPageService myPageService) {
        this.myPageService = myPageService;
    }

    @GetMapping("/card/{userId}")
    public ResponseEntity<GetCardLikeInfoResponseDTO> getCardBookmarks(@PathVariable("userId") String userId) {
        GetCardLikeInfoResponseDTO response = myPageService.getCardBookmarks(userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/deposit/{userId}")
    public ResponseEntity<GetDepositLikeInfoResponseDTO> getDepositBookmarks(@PathVariable("userId") String userId) {
        GetDepositLikeInfoResponseDTO response = myPageService.getDepositBookmarks(userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/saving/{userId}")
    public ResponseEntity<GetSavingLikeInfoResponseDTO> getSavingBookmarks(@PathVariable("userId") String userId) {
        GetSavingLikeInfoResponseDTO response = myPageService.getSavingBookmarks(userId);
        return ResponseEntity.ok(response);
    }
}


package me.assetaid.feature.mypage.application;

import me.assetaid.feature.mypage.application.MyPageService;
import me.assetaid.feature.mypage.application.dto.GetCardLikeInfoResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mypage/bookmark/card")
public class MyPageLikeController {

    private final MyPageService myPageService;

    public MyPageLikeController(MyPageService myPageService) {
        this.myPageService = myPageService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<GetCardLikeInfoResponseDTO> getCardBookmarks(@PathVariable("userId") String userId) {
        GetCardLikeInfoResponseDTO response = myPageService.getCardBookmarks(userId);
        return ResponseEntity.ok(response);
    }
}


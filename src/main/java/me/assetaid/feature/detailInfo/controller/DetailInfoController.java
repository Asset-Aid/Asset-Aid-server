package me.assetaid.feature.detailInfo.controller;

import me.assetaid.feature.detailInfo.application.DetailInfoService;
import me.assetaid.feature.detailInfo.application.dto.GetDepositInfoResponseDTO;
import me.assetaid.feature.detailInfo.application.dto.GetSavingInfoResponseDTO;
import me.assetaid.feature.detailInfo.application.dto.GetCardInfoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recommend")
public class DetailInfoController {

    private final DetailInfoService detailInfoService;

    @Autowired
    public DetailInfoController(DetailInfoService detailInfoService) {
        this.detailInfoService = detailInfoService;
    }

    @GetMapping("/depositInfo/{depositId}")
    public ResponseEntity<GetDepositInfoResponseDTO> getDepositInfo(@PathVariable Integer depositId) {
        GetDepositInfoResponseDTO depositInfo = detailInfoService.getDepositInfoById(depositId);

        if (depositInfo != null) {
            return ResponseEntity.ok(depositInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/savingInfo/{savingId}")
    public ResponseEntity<GetSavingInfoResponseDTO> getSavingInfo(@PathVariable Integer savingId) {
        GetSavingInfoResponseDTO savingInfo = detailInfoService.getSavingInfoById(savingId);

        if (savingInfo != null) {
            return ResponseEntity.ok(savingInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/cardInfo/{cardId}")
    public ResponseEntity<GetCardInfoResponseDTO> getCardInfo(@PathVariable Integer cardId) {
        GetCardInfoResponseDTO cardInfo = detailInfoService.getCardInfoById(cardId);

        if (cardInfo != null) {
            return ResponseEntity.ok(cardInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

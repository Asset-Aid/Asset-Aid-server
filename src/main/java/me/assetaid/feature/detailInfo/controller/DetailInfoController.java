package me.assetaid.feature.detailInfo.controller;

import me.assetaid.feature.detailInfo.application.DetailInfoService;
import me.assetaid.feature.detailInfo.application.dto.GetDepositInfoResponseDTO;
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
}

package me.assetaid.preference.controller;

import me.assetaid.common.dto.CommonIdResponseDto;
import me.assetaid.preference.application.PreferenceService;
import me.assetaid.preference.application.dto.CreatePreferenceRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/preference")
public class PreferenceController {

    private final PreferenceService preferenceService;

    @Autowired
    public PreferenceController(PreferenceService preferenceService) {
        this.preferenceService = preferenceService;
    }

    // 선호도 정보 작성
    @PostMapping("/check")
    public ResponseEntity<CommonIdResponseDto> createPreference(@RequestBody CreatePreferenceRequestDTO dto) {
        CommonIdResponseDto response = preferenceService.createPreference(dto);
        return ResponseEntity.ok(response);
    }
}
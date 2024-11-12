package me.assetaid.preference.application;

import me.assetaid.common.dto.CommonIdResponseDto;
import me.assetaid.preference.application.dto.CreatePreferenceRequestDTO;
import me.assetaid.preference.repository.PreferenceRepository;
import me.assetaid.preference.repository.entity.PreferenceEntity;
import me.assetaid.user.application.UserService;
import me.assetaid.user.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PreferenceService {

    private final PreferenceRepository preferenceRepository;
    private final UserService userService;

    // 선호도 정보 작성
    @Transactional
    public CommonIdResponseDto createPreference(CreatePreferenceRequestDTO dto) {
        // DTO 검증: userId가 필수로 들어왔는지 확인
        Assert.notNull(dto.userId(), "User ID cannot be null");

        // userId로 UserEntity 조회
        UserEntity user = userService.getUserById(dto.userId());

        // PreferenceEntity 생성
        PreferenceEntity preference = new PreferenceEntity(
                dto.availableAmount(),
                dto.debt(),
                dto.salary(),
                dto.spend(),
                dto.investmentStyle(),
                dto.job(),
                dto.knowledgeLevel(),
                user
        );

        // Preference 저장
        PreferenceEntity savedPreference = preferenceRepository.save(preference);

        // 저장된 Preference ID를 반환
        return new CommonIdResponseDto(savedPreference.getPreferenceId());
    }
}

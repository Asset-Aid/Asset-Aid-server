package me.assetaid.preference.application;

import me.assetaid.preference.application.dto.CommonIdResponseDto;
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
        Assert.notNull(dto.userId(), "User ID cannot be null");
        UserEntity user = userService.getUserById(dto.userId());
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

        PreferenceEntity savedPreference = preferenceRepository.save(preference);
        return new CommonIdResponseDto(savedPreference.getPreferenceId());
    }
}

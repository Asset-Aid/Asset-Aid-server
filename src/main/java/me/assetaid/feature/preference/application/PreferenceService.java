package me.assetaid.feature.preference.application;

import me.assetaid.feature.preference.application.dto.CommonIdResponseDto;
import me.assetaid.feature.preference.application.dto.CreatePreferenceRequestDTO;
import me.assetaid.feature.preference.repository.PreferenceRepository;
import me.assetaid.feature.preference.repository.entity.PreferenceEntity;
import me.assetaid.element.user.application.UserService;
import me.assetaid.element.user.repository.entity.UserEntity;
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
                user,
                dto.bankId()
        );

        PreferenceEntity savedPreference = preferenceRepository.save(preference);
        return new CommonIdResponseDto(savedPreference.getPreferenceId());
    }
}

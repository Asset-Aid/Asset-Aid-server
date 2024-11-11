package me.assetaid.preference.application;

import me.assetaid.preference.application.dto.PreferenceDTO;
import me.assetaid.user.application.UserService;
import me.assetaid.user.repository.entity.UserEntity;
import me.assetaid.common.dto.CommonIdResponseDto;
import me.assetaid.common.exception.CommonException;
import me.assetaid.common.exception.ErrorCode;
import me.assetaid.preference.application.dto.CreatePreferenceRequestDTO;
import me.assetaid.preference.application.dto.PreferenceDTO;
import me.assetaid.preference.repository.PreferenceRepository;
import me.assetaid.preference.repository.entity.PreferenceEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PreferenceService {

    private final PreferenceRepository preferenceRepository;
    private final UserService userService;

 //선호도 정보 조회
    public PreferenceEntity findPreference(UUID preferenceId) {
        return preferenceRepository.findById(preferenceId)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_PREFERENCE));
    }
     PreferenceDTO getPreferenceByUserId(UUID userId) {
        UserEntity user = userService.getUserById(userId);
        PreferenceEntity preference = preferenceRepository.findByUser(user)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_PREFERENCE));

        return PreferenceDTO.fromEntity(preference);
    }
  //선호도 정보 생성
    @Transactional
    public CommonIdResponseDto createPreference(CreatePreferenceRequestDTO dto) {
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

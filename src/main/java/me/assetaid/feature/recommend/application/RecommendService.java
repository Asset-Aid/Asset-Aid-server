package me.assetaid.feature.recommend.application;

import me.assetaid.feature.recommend.application.dto.GetDepositRecommendDTO;
import me.assetaid.element.deposit.repository.DepositRepository;
import me.assetaid.feature.preference.repository.PreferenceRepository;
import me.assetaid.feature.preference.repository.entity.PreferenceEntity;
import me.assetaid.element.deposit.repository.entity.DepositEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecommendService {

    private final DepositRepository depositRepository;
    private final PreferenceRepository preferenceRepository;

    @Autowired
    public RecommendService(DepositRepository depositRepository, PreferenceRepository preferenceRepository) {
        this.depositRepository = depositRepository;
        this.preferenceRepository = preferenceRepository;
    }

    public List<GetDepositRecommendDTO> getTop10DepositsForPreferredBank(String userId) {
        Optional<PreferenceEntity> preferenceOptional = preferenceRepository.findByUserId(userId);

        if (preferenceOptional.isEmpty()) {
            return List.of();
        }

        Integer preferredBank = preferenceOptional.get().getBankId();
        PageRequest pageRequest = PageRequest.of(0, 10);
        List<DepositEntity> topDeposits = depositRepository.findByBankIdOrderByViewCountDesc(preferredBank, pageRequest);

        return topDeposits.stream()
                .map(deposit -> new GetDepositRecommendDTO(
                        deposit.getDepositId(),
                        deposit.getDepositName(),
                        deposit.getBankId(),
                        deposit.getBankColor()
                ))
                .collect(Collectors.toList());
    }
}

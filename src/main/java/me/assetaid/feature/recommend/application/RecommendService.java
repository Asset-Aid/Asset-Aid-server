package me.assetaid.feature.recommend.application;

import me.assetaid.feature.recommend.application.dto.GetDepositRecommendDTO;
import me.assetaid.feature.recommend.application.dto.GetCardRecommendDTO;
import me.assetaid.feature.recommend.application.dto.GetSavingRecommendDTO;
import me.assetaid.element.deposit.repository.DepositRepository;
import me.assetaid.element.card.repository.CardRepository;
import me.assetaid.element.saving.repository.SavingRepository;
import me.assetaid.feature.preference.repository.PreferenceRepository;
import me.assetaid.feature.preference.repository.entity.PreferenceEntity;
import me.assetaid.element.deposit.repository.entity.DepositEntity;
import me.assetaid.element.card.repository.entity.CardEntity;
import me.assetaid.element.saving.repository.entity.SavingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecommendService {

    private final DepositRepository depositRepository;
    private final CardRepository cardRepository;
    private final SavingRepository savingRepository;
    private final PreferenceRepository preferenceRepository;

    @Autowired
    public RecommendService(DepositRepository depositRepository, CardRepository cardRepository, SavingRepository savingRepository, PreferenceRepository preferenceRepository) {
        this.depositRepository = depositRepository;
        this.cardRepository = cardRepository;
        this.savingRepository = savingRepository;
        this.preferenceRepository = preferenceRepository;
    }

    public List<GetDepositRecommendDTO> getTop10DepositsForPreferredBank(String userId) {
        Optional<PreferenceEntity> preferenceOptional = preferenceRepository.findByUserId(userId);

        if (preferenceOptional.isEmpty()) {
            return List.of();
        }

        List<Integer> preferredBankIds = preferenceOptional.get().getBankId();
        PageRequest pageRequest = PageRequest.of(0, 10);
        List<DepositEntity> topDeposits = depositRepository.findByBankIdInOrderByViewCountDesc(preferredBankIds, pageRequest);

        return topDeposits.stream()
                .map(deposit -> new GetDepositRecommendDTO(
                        deposit.getDepositId(),
                        deposit.getDepositName(),
                        preferredBankIds,
                        deposit.getBankColor()
                ))
                .collect(Collectors.toList());
    }

    public List<GetCardRecommendDTO> getTop10CardsForPreferredBank(String userId) {
        Optional<PreferenceEntity> preferenceOptional = preferenceRepository.findByUserId(userId);

        if (preferenceOptional.isEmpty()) {
            return List.of();
        }

        List<Integer> preferredBankIds = preferenceOptional.get().getBankId();
        PageRequest pageRequest = PageRequest.of(0, 10);
        List<CardEntity> topCards = cardRepository.findByBankIdInOrderByViewCountDesc(preferredBankIds, pageRequest);

        return topCards.stream()
                .map(card -> new GetCardRecommendDTO(
                        card.getCardId(),
                        card.getCardName(),
                        preferredBankIds,
                        card.getBankColor()
                ))
                .collect(Collectors.toList());
    }

    public List<GetSavingRecommendDTO> getTop10SavingsForPreferredBank(String userId) {
        Optional<PreferenceEntity> preferenceOptional = preferenceRepository.findByUserId(userId);

        if (preferenceOptional.isEmpty()) {
            return List.of();
        }

        List<Integer> preferredBankIds = preferenceOptional.get().getBankId();
        PageRequest pageRequest = PageRequest.of(0, 10);
        List<SavingEntity> topSavings = savingRepository.findByBankIdInOrderByViewCountDesc(preferredBankIds, pageRequest);

        return topSavings.stream()
                .map(saving -> new GetSavingRecommendDTO(
                        saving.getSavingId(),
                        saving.getSavingName(),
                        preferredBankIds,
                        saving.getBankColor()
                ))
                .collect(Collectors.toList());
    }
}

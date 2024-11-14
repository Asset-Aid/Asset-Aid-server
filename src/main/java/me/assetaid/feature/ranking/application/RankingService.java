package me.assetaid.feature.ranking.application;

import me.assetaid.feature.ranking.application.dto.GetDepositRankingDTO;
import me.assetaid.feature.ranking.application.dto.GetCardRankingDTO;
import me.assetaid.feature.ranking.application.dto.GetSavingRankingDTO;
import me.assetaid.element.deposit.repository.DepositRepository;
import me.assetaid.element.deposit.repository.entity.DepositEntity;
import me.assetaid.element.card.repository.CardRepository;
import me.assetaid.element.card.repository.entity.CardEntity;
import me.assetaid.element.saving.repository.SavingRepository;
import me.assetaid.element.saving.repository.entity.SavingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RankingService {

    private final DepositRepository depositRepository;
    private final CardRepository cardRepository;
    private final SavingRepository savingRepository;

    @Autowired
    public RankingService(DepositRepository depositRepository, CardRepository cardRepository, SavingRepository savingRepository) {
        this.depositRepository = depositRepository;
        this.cardRepository = cardRepository;
        this.savingRepository = savingRepository;
    }

    public List<GetDepositRankingDTO> getTop3DepositsByViewCount() {
        List<DepositEntity> topDeposits = depositRepository.findTop3ByOrderByViewCountDesc();
        return topDeposits.stream()
                .map(deposit -> new GetDepositRankingDTO(deposit.getDepositId(), deposit.getDepositName(), deposit.getBank()))
                .collect(Collectors.toList());
    }

    public List<GetCardRankingDTO> getTop3CardsByViewCount() {
        List<CardEntity> topCards = cardRepository.findTop3ByOrderByViewCountDesc();
        return topCards.stream()
                .map(card -> new GetCardRankingDTO(card.getCardId(), card.getCardName(), card.getBank()))
                .collect(Collectors.toList());
    }

    public List<GetSavingRankingDTO> getTop3SavingsByViewCount() {
        List<SavingEntity> topSavings = savingRepository.findTop3ByOrderByViewCountDesc();
        return topSavings.stream()
                .map(saving -> new GetSavingRankingDTO(saving.getSavingId(), saving.getSavingName(), saving.getBank()))
                .collect(Collectors.toList());
    }
}

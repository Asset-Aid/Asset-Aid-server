package me.assetaid.feature.detailInfo.application;

import me.assetaid.feature.detailInfo.application.dto.GetDepositInfoResponseDTO;
import me.assetaid.feature.detailInfo.application.dto.GetSavingInfoResponseDTO;
import me.assetaid.feature.detailInfo.application.dto.GetCardInfoResponseDTO;
import me.assetaid.element.deposit.repository.DepositRepository;
import me.assetaid.element.saving.repository.SavingRepository;
import me.assetaid.element.card.repository.CardRepository;
import me.assetaid.element.deposit.repository.entity.DepositEntity;
import me.assetaid.element.saving.repository.entity.SavingEntity;
import me.assetaid.element.card.repository.entity.CardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DetailInfoService {

    private final DepositRepository depositRepository;
    private final SavingRepository savingRepository;
    private final CardRepository cardRepository;

    @Autowired
    public DetailInfoService(DepositRepository depositRepository, SavingRepository savingRepository, CardRepository cardRepository) {
        this.depositRepository = depositRepository;
        this.savingRepository = savingRepository;
        this.cardRepository = cardRepository;
    }

    public GetDepositInfoResponseDTO getDepositInfoById(Integer depositId) {
        Optional<DepositEntity> depositEntityOptional = depositRepository.findById(depositId);

        if (depositEntityOptional.isPresent()) {
            DepositEntity deposit = depositEntityOptional.get();

            return new GetDepositInfoResponseDTO(
                    deposit.getDepositId(),
                    deposit.getDepositName(),
                    deposit.getBank(),
                    deposit.getJoinWay(),
                    deposit.getStartAt(),
                    deposit.getEndAt(),
                    deposit.getLimitDeposit(),
                    deposit.getContents(),
                    deposit.getIntRate()
            );
        } else {
            return null;
        }
    }

    public GetSavingInfoResponseDTO getSavingInfoById(Integer savingId) {
        Optional<SavingEntity> savingEntityOptional = savingRepository.findById(savingId);

        if (savingEntityOptional.isPresent()) {
            SavingEntity saving = savingEntityOptional.get();

            return new GetSavingInfoResponseDTO(
                    saving.getSavingId(),
                    saving.getSavingName(),
                    saving.getBank(),
                    saving.getJoinWay(),
                    saving.getStartAt(),
                    saving.getEndAt(),
                    saving.getLimitSaving(),
                    saving.getContents()
            );
        } else {
            return null;
        }
    }

    public GetCardInfoResponseDTO getCardInfoById(Integer cardId) {
        Optional<CardEntity> cardEntityOptional = cardRepository.findById(cardId);

        if (cardEntityOptional.isPresent()) {
            CardEntity card = cardEntityOptional.get();

            return new GetCardInfoResponseDTO(
                    card.getCardId(),
                    card.getAnnualFeeFor(),
                    card.getAnnualFeeKor(),
                    card.getCardLimit(),
                    card.getCardType(),
                    card.getCardImage(),
                    card.getBank(),
                    card.getBenefit(),
                    card.getCardName()
            );
        } else {
            return null;
        }
    }
}

package me.assetaid.feature.click.application;

import me.assetaid.element.deposit.repository.DepositRepository;
import me.assetaid.element.deposit.repository.entity.DepositEntity;
import me.assetaid.element.card.repository.CardRepository;
import me.assetaid.element.card.repository.entity.CardEntity;
import me.assetaid.element.saving.repository.SavingRepository;
import me.assetaid.element.saving.repository.entity.SavingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClickService {

    private final DepositRepository depositRepository;
    private final CardRepository cardRepository;
    private final SavingRepository savingRepository;

    @Autowired
    public ClickService(DepositRepository depositRepository, CardRepository cardRepository, SavingRepository savingRepository) {
        this.depositRepository = depositRepository;
        this.cardRepository = cardRepository;
        this.savingRepository = savingRepository;
    }

    public boolean increaseDepositViewCount(Integer depositId) {
        Optional<DepositEntity> depositOpt = depositRepository.findById(depositId);
        if (depositOpt.isPresent()) {
            DepositEntity deposit = depositOpt.get();
            deposit.setViewCount(deposit.getViewCount() + 1);
            depositRepository.save(deposit);
            return true;
        }
        return false;
    }

    public boolean increaseCardViewCount(Integer cardId) {
        Optional<CardEntity> cardOpt = cardRepository.findById(cardId);
        if (cardOpt.isPresent()) {
            CardEntity card = cardOpt.get();
            card.setViewCount(card.getViewCount() + 1);
            cardRepository.save(card);
            return true;
        }
        return false;
    }

    public boolean increaseSavingViewCount(Integer savingId) {
        Optional<SavingEntity> savingOpt = savingRepository.findById(savingId);
        if (savingOpt.isPresent()) {
            SavingEntity saving = savingOpt.get();
            saving.setViewCount(saving.getViewCount() + 1);
            savingRepository.save(saving);
            return true;
        }
        return false;
    }
}

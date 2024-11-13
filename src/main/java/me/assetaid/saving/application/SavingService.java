package me.assetaid.saving.application;

import me.assetaid.saving.repository.SavingRepository;
import me.assetaid.saving.repository.entity.SavingEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SavingService {

    private final SavingRepository savingRepository;

    public SavingService(SavingRepository savingRepository) {
        this.savingRepository = savingRepository;
    }

    @Transactional(readOnly = true)
    public SavingEntity getSavingById(Integer savingId) {
        return savingRepository.findById(savingId)
                .orElseThrow(() -> new IllegalArgumentException("Saving not found with ID: " + savingId));
    }
}
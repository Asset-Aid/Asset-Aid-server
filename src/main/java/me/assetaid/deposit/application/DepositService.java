package me.assetaid.deposit.application;

import me.assetaid.deposit.repository.entity.DepositEntity;
import me.assetaid.deposit.repository.DepositRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepositService {

    private final DepositRepository depositRepository;

    public DepositService(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;
    }

    @Transactional(readOnly = true)
    public DepositEntity getDepositById(Integer depositId) {
        return depositRepository.findById(depositId)
                .orElseThrow(() -> new IllegalArgumentException("Deposit not found with ID: " + depositId));
    }
}

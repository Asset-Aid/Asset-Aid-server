package me.assetaid.feature.detailInfo.application;

import me.assetaid.feature.detailInfo.application.dto.GetDepositInfoResponseDTO;
import me.assetaid.element.deposit.repository.DepositRepository;
import me.assetaid.element.deposit.repository.entity.DepositEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DetailInfoService {

    private final DepositRepository depositRepository;

    @Autowired
    public DetailInfoService(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;
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
}

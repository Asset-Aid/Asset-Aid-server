package me.assetaid.feature.ranking.application;

import me.assetaid.feature.ranking.application.dto.GetDepositRankingDTO;
import me.assetaid.element.deposit.repository.DepositRepository;
import me.assetaid.element.deposit.repository.entity.DepositEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RankingService {

    private final DepositRepository depositRepository;

    @Autowired
    public RankingService(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;
    }

    public List<GetDepositRankingDTO> getTop3DepositsByViewCount() {
        List<DepositEntity> topDeposits = depositRepository.findTop3ByOrderByViewCountDesc();
        return topDeposits.stream()
                .map(deposit -> new GetDepositRankingDTO(deposit.getDepositName(), deposit.getBank()))
                .collect(Collectors.toList());
    }
}

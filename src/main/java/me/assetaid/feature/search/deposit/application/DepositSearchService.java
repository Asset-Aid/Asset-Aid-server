package me.assetaid.feature.search.deposit.application;

import me.assetaid.feature.search.deposit.application.dto.DepositSearchRequestDTO;
import me.assetaid.feature.search.deposit.application.dto.DepositSearchResponseDTO;
import me.assetaid.feature.search.deposit.repository.DepositSearchRepository;
import me.assetaid.feature.search.deposit.repository.entity.DepositEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepositSearchService {
    private final DepositSearchRepository depositSearchRepository;

    public DepositSearchService(DepositSearchRepository depositSearchRepository) {
        this.depositSearchRepository = depositSearchRepository;
    }

    public List<DepositSearchResponseDTO> searchDeposits(DepositSearchRequestDTO request) {
        List<DepositEntity> results = depositSearchRepository.searchDeposits(
                request.getBankNames(),
                request.getDepositType(),
                request.getSavingTerm()
        );

        return results.stream()
                .map(entity -> new DepositSearchResponseDTO(
                        entity.getProductName(),                    // 상품명
                        entity.getBankName(),                       // 은행 이름
                        entity.getSalesPeriod(),                    // 판매 기간
                        entity.getSavingTerm(),                     // 가입 기간
                        String.valueOf(entity.getSubscriptionAmount()),  // double을 String으로 변환
                        entity.getBasicInterestRate(),              // 기본 금리
                        entity.getMaxInterestRate()                 // 최고 금리
                ))
                .collect(Collectors.toList());
    }


}

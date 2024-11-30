package me.assetaid.feature.search.savings.application;

import lombok.RequiredArgsConstructor;
import me.assetaid.feature.search.savings.application.dto.SavingsSearchResponseDTO;
import me.assetaid.feature.search.savings.repository.SavingsSearchRepository;
import me.assetaid.feature.search.savings.repository.entity.SavingsEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SavingsSearchService {

    private final SavingsSearchRepository savingsSearchRepository;

    public List<SavingsSearchResponseDTO> searchSavings(
            List<String> bankNames,
            String savingsType,
            Integer minTerm,
            Integer maxTerm,
            Double minAmount) {

        if (bankNames == null || bankNames.isEmpty() || savingsType == null || savingsType.isEmpty()
                || minTerm == null || maxTerm == null || minAmount == null) {
            throw new IllegalArgumentException("모든 검색 조건(은행, 유형, 기간, 금액)을 입력해야 합니다.");
        }

        List<SavingsEntity> entities = savingsSearchRepository.searchSavings(bankNames, savingsType, minTerm, maxTerm, minAmount);

        return entities.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private SavingsSearchResponseDTO mapToDTO(SavingsEntity entity) {
        // 기본 금리와 최고 금리를 contents에서 추출
        Double baseRate = extractRate(entity.getContents(), "기본금리\\s([0-9.]+)%");
        Double maxRate = extractRate(entity.getContents(), "최고금리\\s([0-9.]+)%");

        // 가입 기간 생성
        String joinPeriod = formatJoinPeriod(entity.getStartAt(), entity.getEndAt());

        return new SavingsSearchResponseDTO(
                entity.getSavingName(),
                entity.getBankName(),
                joinPeriod,
                entity.getLimitDeposit(),
                baseRate,
                maxRate
        );
    }

    // 금리 추출 메서드
    private Double extractRate(String contents, String pattern) {
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(contents);
        if (matcher.find()) {
            return Double.parseDouble(matcher.group(1));
        }
        return null;
    }

    // 가입 기간 형식 변환
    private String formatJoinPeriod(String startAt, String endAt) {
        if (endAt == null || endAt.equalsIgnoreCase("null")) {
            return startAt + " ~ 무기한";
        }
        return startAt + " ~ " + endAt;
    }
}

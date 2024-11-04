package me.assetaid.parsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.assetaid.entity.DepositEntity;
import me.assetaid.entity.SavingEntity;
import me.assetaid.repository.DepositRepository;
import me.assetaid.repository.SavingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Logger;

@Service
public class ApiParsing {

    private static final Logger logger = Logger.getLogger(ApiParsing.class.getName());
    private static Properties prop = new Properties();

    @Autowired
    private DepositRepository depositRepository;

    @Autowired
    private SavingRepository savingRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public ApiParsing() throws IOException {
        try (InputStream input = ApiParsing.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                logger.warning("config.properties 파일을 찾을 수 없습니다.");
                return;
            }
            prop.load(input);
        }
    }

    public void parseSavingsAndDeposits() throws IOException {
        logger.info("파싱 시작");

        // 적금 API
        int totalPages = 3;
        for (int pageNo = 1; pageNo <= totalPages; pageNo++) {
            String apiSavingUrl = buildApiSavingUrl(pageNo);
            String apiSavingResponse = getApiResponse(apiSavingUrl);
            saveSavingsData(apiSavingResponse);
        }

        // 예금 API
        for (int pageNo = 1; pageNo <= totalPages; pageNo++) {
            String apiDepositUrl = buildApiDepositUrl(pageNo);
            String apiDepositResponse = getApiResponse(apiDepositUrl);
            saveDepositData(apiDepositResponse);
        }
    }

    private String buildApiSavingUrl(int pageNo) {
        String apiKey = prop.getProperty("API_KEY");
        if (apiKey == null) {
            logger.warning("API_KEY가 config.properties 파일에 정의되어 있지 않습니다.");
            return null;
        }

        StringBuilder urlBuilder = new StringBuilder("http://finlife.fss.or.kr/finlifeapi/savingProductsSearch.json");
        urlBuilder.append("?auth=").append(apiKey);
        urlBuilder.append("&topFinGrpNo=020000");
        urlBuilder.append("&pageNo=").append(pageNo);

        return urlBuilder.toString();
    }

    private String buildApiDepositUrl(int pageNo) {
        String apiKey = prop.getProperty("API_KEY");
        if (apiKey == null) {
            logger.warning("API_KEY가 config.properties 파일에 정의되어 있지 않습니다.");
            return null;
        }

        StringBuilder urlBuilder = new StringBuilder("http://finlife.fss.or.kr/finlifeapi/depositProductsSearch.json");
        urlBuilder.append("?auth=").append(apiKey);
        urlBuilder.append("&topFinGrpNo=020000");
        urlBuilder.append("&pageNo=").append(pageNo);

        return urlBuilder.toString();
    }

    private String getApiResponse(String urlStr) throws IOException {
        if (urlStr == null) {
            return "URL이 null입니다. API_KEY가 제대로 로드되지 않았거나 URL 생성에 문제가 있습니다.";
        }
        logger.info("요청 URL: " + urlStr);

        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setInstanceFollowRedirects(true);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        int responseCode = conn.getResponseCode();
        logger.info("HTTP 응답 코드: " + responseCode);

        BufferedReader rd;
        if (responseCode >= 200 && responseCode <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else if (responseCode == 307) {
            String redirectUrl = conn.getHeaderField("Location");
            if (redirectUrl != null) {
                return getApiResponse(redirectUrl);
            } else {
                return "리다이렉트 URL을 찾을 수 없습니다.";
            }
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        return sb.toString();
    }

    private void saveDepositData(String jsonResponse) throws IOException {
        JsonNode rootNode = objectMapper.readTree(jsonResponse);
        JsonNode baseList = rootNode.path("result").path("baseList");

        for (JsonNode node : baseList) {
            DepositEntity deposit = new DepositEntity();
            deposit.setDepositId(node.path("fin_prdt_cd").asInt());
            deposit.setBank(node.path("kor_co_nm").asText());
            deposit.setDepositName(node.path("fin_prdt_nm").asText());
            deposit.setJoinWay(node.path("join_way").asText());
            deposit.setIntRate(node.path("mtrt_int").asInt());
            deposit.setContents(node.path("spcl_cnd").asText() + " " + node.path("join_member").asText() + " " + node.path("etc_note").asText());
            deposit.setLimitDeposit(node.path("max_limit").asInt());
            deposit.setStartAt(node.path("dcls_strt_day").asText());
            deposit.setEndAt(node.path("dcls_end_day").asText());

            depositRepository.save(deposit);
            logger.info("예금 데이터 저장 완료: " + deposit.toString());
        }
    }

    private void saveSavingsData(String jsonResponse) throws IOException {
        JsonNode rootNode = objectMapper.readTree(jsonResponse);
        JsonNode baseList = rootNode.path("result").path("baseList");

        for (JsonNode node : baseList) {
            SavingEntity saving = new SavingEntity();
            saving.setSavingId(node.path("fin_prdt_cd").asInt());
            saving.setBank(node.path("kor_co_nm").asText());
            saving.setSavingName(node.path("fin_prdt_nm").asText());
            saving.setJoinWay(node.path("join_way").asText());
            saving.setRsrvRate(node.path("mtrt_int").asInt());
            saving.setContents(node.path("spcl_cnd").asText() + " " + node.path("join_member").asText() + " " + node.path("etc_note").asText());
            saving.setLimitSaving(node.path("max_limit").asInt());
            saving.setStartAt(node.path("dcls_strt_day").asText());
            saving.setEndAt(node.path("dcls_end_day").asText());

            savingRepository.save(saving);
            logger.info("적금 데이터 저장 완료: " + saving.toString());
        }
    }
}

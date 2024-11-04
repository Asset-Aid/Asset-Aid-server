package me.assetaid.parsing;

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
            logger.info("적금 API - Page " + pageNo);
            logger.info(apiSavingResponse);
        }

        // 예금 API
        for (int pageNo = 1; pageNo <= totalPages; pageNo++) {
            String apiDepositUrl = buildApiDepositUrl(pageNo);
            String apiDepositResponse = getApiResponse(apiDepositUrl);
            logger.info("예금 API - Page " + pageNo);
            logger.info(apiDepositResponse);
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
        conn.setInstanceFollowRedirects(true); // 리다이렉트를 자동으로 따르게 설정
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        int responseCode = conn.getResponseCode();
        logger.info("HTTP 응답 코드: " + responseCode);

        BufferedReader rd;
        if (responseCode >= 200 && responseCode <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else if (responseCode == 307) {
            // 리다이렉트 URL로 재시도
            String redirectUrl = conn.getHeaderField("Location");
            if (redirectUrl != null) {
                return getApiResponse(redirectUrl); // 재귀 호출로 리다이렉트 URL 처리
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

}

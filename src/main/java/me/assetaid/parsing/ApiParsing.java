package me.assetaid.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ApiParsing {
    public static void main(String[] args) throws IOException {
        // 적금 API
        String apiSavingUrl = buildApiSavingUrl();
        String apiSavingResponse = getApiResponse(apiSavingUrl);
        System.out.println("적금 API");
        System.out.println(apiSavingResponse);

        // 예금 API
        String apidepositUrl = buildApiDepositUrl();
        String api2Response = getApiResponse(apidepositUrl);
        System.out.println("예금 API");
        System.out.println(api2Response);
    }

    // API 1 URL 생성
    private static String buildApiSavingUrl() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://finlife.fss.or.kr/finlifeapi/companySearch.json?auth=인증키/");
        urlBuilder.append("/" + URLEncoder.encode("인증키", "UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("json", "UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("CardSubwayStatsNew", "UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("1", "UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("5", "UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("20220301", "UTF-8"));
        return urlBuilder.toString();
    }

    // API 2 URL 생성
    private static String buildApiDepositUrl() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://openapi.example.com/api2");
        urlBuilder.append("/" + URLEncoder.encode("인증키", "UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("json", "UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("ServiceNameForAPI2", "UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("1", "UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("5", "UTF-8"));
        return urlBuilder.toString();
    }

    private static String getApiResponse(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        BufferedReader rd;

        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
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

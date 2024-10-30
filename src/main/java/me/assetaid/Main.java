package me.assetaid;

import me.assetaid.crawler.Crawler;
import me.assetaid.crawler.WebDriverUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        WebDriverUtil webDriverUtil = new WebDriverUtil("chromeDriverPath"); // WebDriverUtil 인스턴스 생성
        Crawler crawler = new Crawler(webDriverUtil); // Crawler 인스턴스 생성

        crawler.crawlAllLinks(); // 모든 링크를 동적으로 수집 및 크롤링 수행
        crawler.quit();  // WebDriver 종료
    }
}

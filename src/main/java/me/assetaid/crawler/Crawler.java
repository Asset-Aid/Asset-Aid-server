package me.assetaid.crawler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.util.ObjectUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Crawler {
    private WebDriver driver;
    private List<WebElement> webElementList;
    private String baseUrl = "https://new-m.pay.naver.com/affiliate-card/home"; // 시작 페이지 URL
    private String linkQuery = ".ProductListItem_item__RsBV_"; // 각 상세 페이지로 연결되는 링크의 CSS 선택자 (a 태그 포함)
    private String contentQuery = ".FlexibleLayout-module_inner__hGuDc.FlexibleLayout-module_type-full-height__4230p.Detail_article__MtRYb"; // 상세 페이지에서 크롤링할 요소의 CSS 선택자

    // 생성자에서 WebDriver 초기화
    public Crawler(WebDriverUtil webDriverUtil) {
        this.driver = webDriverUtil.createDriver();
        this.webElementList = new ArrayList<>();
    }

    // 메인 페이지에서 링크 수집 및 각 링크에 대해 크롤링 수행
    public void crawlAllLinks() {
        if (ObjectUtils.isEmpty(driver)) {
            return;
        }

        // 1. 메인 페이지 열기 및 링크 수집
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> linkElements = driver.findElements(By.cssSelector(linkQuery));

        // 2. 수집한 링크들 순회하면서 크롤링 수행
        for (WebElement linkElement : linkElements) {
            String detailUrl = linkElement.getAttribute("href");
            if (detailUrl != null && !detailUrl.isEmpty()) {
                // 각 상세 페이지 접근
                driver.get(detailUrl);

                try {
                    Thread.sleep(2000); // 명시적 대기 시간
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 상세 페이지에서 크롤링할 데이터 수집
                List<WebElement> contentElements = driver.findElements(By.cssSelector(contentQuery));
                System.out.println("URL: " + detailUrl);
                for (WebElement contentElement : contentElements) {
                    System.out.println(contentElement.getText());
                }
                System.out.println("---------------------------------");
            }
        }
    }

    // WebDriver 종료 메서드
    public void quit() {
        if (!ObjectUtils.isEmpty(driver)) {
            driver.quit();
        }
    }
}
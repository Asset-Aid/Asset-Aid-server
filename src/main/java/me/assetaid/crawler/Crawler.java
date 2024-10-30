package me.assetaid.crawler;

import me.assetaid.crawler.WebDriverUtil;
import me.assetaid.entity.CardEntity;
import me.assetaid.repository.CardRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

@Component
public class Crawler {
    private WebDriver driver;
    private final CardRepository cardRepository;
    private final WebDriverUtil webDriverUtil;
    private final Logger logger = Logger.getLogger(Crawler.class.getName());

    private String baseUrl = "https://new-m.pay.naver.com/affiliate-card/home";
    private String linkQuery = ".ProductListItem_item__RsBV_";
    private String contentQuery = ".FlexibleLayout-module_inner__hGuDc.FlexibleLayout-module_type-full-height__4230p.Detail_article__MtRYb";

    @Autowired
    public Crawler(WebDriverUtil webDriverUtil, CardRepository cardRepository) {
        this.webDriverUtil = webDriverUtil;
        this.cardRepository = cardRepository;
    }

    public void crawlAllLinks() {
        this.driver = webDriverUtil.createDriver();
        if (ObjectUtils.isEmpty(driver)) {
            logger.warning("WebDriver 인스턴스를 생성하지 못했습니다.");
            return;
        }

        try {
            driver.get(baseUrl);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            List<WebElement> linkElements = driver.findElements(By.cssSelector(linkQuery));
            logger.info("총 " + linkElements.size() + "개의 링크를 발견했습니다.");

            for (WebElement linkElement : linkElements) {
                String detailUrl = linkElement.getAttribute("href");
                if (detailUrl != null && !detailUrl.isEmpty()) {
                    driver.get(detailUrl);
                    Thread.sleep(2000);

                    List<WebElement> contentElements = driver.findElements(By.cssSelector(contentQuery));
                    StringBuilder contentBuilder = new StringBuilder();
                    for (WebElement contentElement : contentElements) {
                        contentBuilder.append(contentElement.getText()).append("\n");
                    }

                    CardEntity cardEntity = new CardEntity();
                    cardEntity.setUrl(detailUrl);
                    cardEntity.setContent(contentBuilder.toString());
                    cardRepository.save(cardEntity);  // 데이터베이스에 저장
                    logger.info("카드 정보가 저장되었습니다: " + cardEntity);
                }
            }
        } catch (Exception e) {
            logger.severe("크롤링 중 오류 발생: " + e.getMessage());
        } finally {
            quit();
        }
    }


    public void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

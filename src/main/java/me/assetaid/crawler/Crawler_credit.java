//package me.assetaid.crawler;
//
//import me.assetaid.entity.CardEntity;
//import me.assetaid.repository.CardRepository;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.util.ObjectUtils;
//
//import java.time.Duration;
//import java.util.List;
//import java.util.logging.Logger;
//
//@Component
//public class Crawler_credit {
//    private WebDriver driver;
//    private final CardRepository cardRepository;
//    private final WebDriverUtil webDriverUtil;
//    private final Logger logger = Logger.getLogger(Crawler_credit.class.getName());
//
//    private String baseUrl = "https://card-gorilla.com/card?cate=CRD";
//    private String linkQuery = "a.lst_more";
//    private String contentQuery = "li[data-v-a39427d0][data-v-35734774]";
//
//    public void loadAllCards() {
//        boolean hasMore = true;
//        while (hasMore) {
//            try {
//                WebElement loadMoreButton = driver.findElement(By.cssSelector("a.lst_more"));
//                logger.info("더보기 버튼을 찾았습니다.");
//                loadMoreButton.click();
//                Thread.sleep(2000);
//            } catch (Exception e) {
//                hasMore = false;
//                logger.info("더보기 버튼을 찾을 수 없음");
//            }
//        }
//    }
//
//    @Autowired
//    public Crawler_credit(WebDriverUtil webDriverUtil, CardRepository cardRepository) {
//        this.webDriverUtil = webDriverUtil;
//        this.cardRepository = cardRepository;
//    }
//
//    public void crawlAllLinks() {
//        this.driver = webDriverUtil.createDriver();
//        if (ObjectUtils.isEmpty(driver)) {
//            logger.warning("WebDriver 인스턴스를 생성하지 못했습니다.");
//            return;
//        }
//
//        try {
//            driver.get(baseUrl);
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//            loadAllCards();
//
//            List<WebElement> cardElements = driver.findElements(By.cssSelector(contentQuery));
//            logger.info("총 " + cardElements.size() + "개의 카드 요소를 발견했습니다.");
//
//            if (cardElements.isEmpty()) {
//                logger.warning("카드 요소를 찾지 못했습니다. 선택자를 확인하세요.");
//            }
//
//            for (WebElement cardElement : cardElements) {
//                CardEntity cardEntity = new CardEntity();
//                cardEntity.setUrl(baseUrl);
//
//                WebElement inForElement = cardElement.findElement(By.cssSelector(".in_for"));
//                String[] annualFees = inForElement.getText().split("/");
//
//                if (annualFees.length > 0) {
//                    cardEntity.setAnnualFeeKor(parseInteger(annualFees[0]));
//                }
//                if (annualFees.length > 1) {
//                    cardEntity.setAnnualFeeFor(parseInteger(annualFees[1]));
//                }
//
//                WebElement cardCorpElement = cardElement.findElement(By.cssSelector(".card_corp"));
//                cardEntity.setBank(cardCorpElement.getText());
//                cardEntity.setCardType(0);
//                WebElement saleElement = cardElement.findElement(By.cssSelector(".sale"));
//                cardEntity.setBenefit(saleElement.getText());
//
//                WebElement cardImgElement = cardElement.findElement(By.cssSelector(".img img"));
//                cardEntity.setCardImage(cardImgElement.getAttribute("src"));
//
//                WebElement lMthElement = cardElement.findElement(By.cssSelector(".l_mth"));
//                cardEntity.setCardLimit(parseInteger(lMthElement.getText()));
//
//                WebElement nameElement = cardElement.findElement(By.cssSelector(".name"));
//                cardEntity.setCardName(nameElement.getText());
//
//                cardRepository.save(cardEntity);
//                logger.info("카드 정보가 저장되었습니다: " + cardEntity);
//            }
//        } catch (Exception e) {
//            logger.severe("크롤링 중 오류 발생: " + e.getMessage());
//        } finally {
//            quit();
//        }
//    }
//
//    private Integer parseInteger(String text) {
//        try {
//            return Integer.parseInt(text.replaceAll("[^0-9]", ""));
//        } catch (NumberFormatException e) {
//            return null;
//        }
//    }
//
//    public void quit() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//            logger.info("WebDriver 종료");
//        }
//    }
//}

package me.assetaid.crawler;

import static org.junit.jupiter.api.Assertions.assertFalse;

import me.assetaid.Main;
import me.assetaid.crawler.Crawler;
import me.assetaid.repository.CardRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

@ComponentScan(basePackages = "me.assetaid")
@SpringBootTest(classes = Main.class)
@Transactional
public class CrawlerTest {

    @Autowired
    private Crawler crawler;

    @Autowired
    private CardRepository cardRepository;

    @Test
    public void testCrawlAllLinks() {
        crawler.crawlAllLinks();
        assertFalse(cardRepository.findAll().isEmpty(), "크롤링 후 데이터가 저장되지 않았습니다.");
    }
    @AfterEach
    public void tearDown() {
        crawler.quit();
    }
}


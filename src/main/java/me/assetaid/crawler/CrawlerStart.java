package me.assetaid.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CrawlerStart implements CommandLineRunner {

    private final Crawler_credit crawlerCredit;
    private final Crawler_check crawlerCheck;

    @Autowired
    public CrawlerStart(Crawler_credit crawlerCredit, Crawler_check crawlerCheck) {
        this.crawlerCredit = crawlerCredit;
        this.crawlerCheck = crawlerCheck;
    }

    @Override
    public void run(String... args) throws Exception {
        crawlerCredit.crawlAllLinks();
        crawlerCheck.crawlAllLinks();
    }
}

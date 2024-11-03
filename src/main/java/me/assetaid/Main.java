package me.assetaid;

import me.assetaid.crawler.Crawler_credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private final Crawler_credit crawlerCredit;

    @Autowired
    public Main(Crawler_credit crawlerCredit) {
        this.crawlerCredit = crawlerCredit;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        crawlerCredit.crawlAllLinks(); // 모든 링크를 동적으로 수집 및 크롤링 수행
    }
}

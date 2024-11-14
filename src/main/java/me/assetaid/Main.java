package me.assetaid;

import me.assetaid.prepared.parsing.ApiParsing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private ApiParsing apiParsing;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        apiParsing.parseSavingsAndDeposits(); // 파싱 작업 수행
    }
}

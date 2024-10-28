package me.assetaid.crawler;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class WebDriverUtil {

    private static String WEB_DRIVER_PATH;

    // 생성자에서 WebDriver 경로 설정
    public WebDriverUtil(@Value("${driver.chrome.driver_path}") String path) {
        if (ObjectUtils.isEmpty(System.getProperty("webdriver.chrome.driver"))) {
            System.setProperty("webdriver.chrome.driver", path);
        }
        WEB_DRIVER_PATH = path;
    }

    // WebDriver 초기화 및 설정 메서드
    public WebDriver createDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--lang=ko");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.setCapability("ignoreProtectedModeSettings", true);

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        return driver;
    }

    // WebDriver 종료 메서드
    public static void quit(WebDriver driver) {
        if (!ObjectUtils.isEmpty(driver)) {
            driver.quit();
        }
    }

    // WebDriver 닫기 메서드
    public static void close(WebDriver driver) {
        if (!ObjectUtils.isEmpty(driver)) {
            driver.close();
        }
    }
}

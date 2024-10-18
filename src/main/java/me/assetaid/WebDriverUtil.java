package me.assetaid;
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
    if (ObjectUtils.isEmpty(System.getProperty("webdriver.chrome.driver"))){
        System.setProperty("webdriver.chrome.driver", WEB_DRIVER_PATH);
    }

    //webDriver 옵션 설정
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setHeadless(true);
    chromeOptions.addArguments("--lang=ko")
    chromeOptions.addArguments("")
}

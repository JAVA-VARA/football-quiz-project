package com.example.footballquizproject.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

@Component
public class WebDriverUtil {
    public final static String WEB_DRIVER_PATH = "C:\\Users\\sjyou\\Downloads\\chromedriver-win64\\chromedriver.exe";

    public WebDriver connectingDriver(String url) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", WEB_DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        Thread.sleep(1000);

        return driver;
    }

    public void scrollDriver(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long pageHeight = (Long) js.executeScript("return document.body.scrollHeight");

        for (int i = 0; i < pageHeight; i += 1000) {
            js.executeScript("window.scrollTo(0, " + i + ")");
            Thread.sleep(500); // 스크롤 시간을 기다림 (필요에 따라 조절)
        }
    }
}

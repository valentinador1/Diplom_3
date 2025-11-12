package ru.yandex.practicum.tests;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;

import static ru.yandex.practicum.config.YandexConfig.YANDEX;

public class DriverFactory extends ExternalResource {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void initDriver() {
        if("yandex".equals(System.getProperty("browser"))){
            startYandex();
        }else {
            startChrome();
        }
    }

    private void startChrome() {
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    private void startYandex() {

        ChromeOptions options = new ChromeOptions();

        options.setBinary(YANDEX);
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Override
    protected void before() throws Throwable {
        initDriver();
    }

    @Override
    protected void after() {
        if (driver != null) {
            driver.quit();
        }
    }
}
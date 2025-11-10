package ru.yandex.practicum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //кнопка Войти в аккаунт
    private By loginButtonMain = By.xpath("//button[text()='Войти в аккаунт']");

    //кнопка Личный кабинет
    private By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']/ancestor::a");


    private By bunsTab = By.xpath("(//div[contains(@class,'tab_tab__1SPyG')])[1]");
    private By saucesTab = By.xpath("(//div[contains(@class,'tab_tab__1SPyG')])[2]");
    private By fillingsTab = By.xpath("(//div[contains(@class,'tab_tab__1SPyG')])[3]");

    private final String BASE_URL = "https://stellarburgers.education-services.ru/";

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Открыть главную страницу")
    public void open() {
        driver.get(BASE_URL);
    }

    @Step("Нажать на кнопку Войти на главной странице")
    public void clickLoginButtonMain() {
        driver.findElement(loginButtonMain).click();
    }

    @Step("Нажать на кнопку Личный аккаунт")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }


    //    Конструктор
    @Step("Перейти к разделу Булки")
    public void goToBuns() {
        driver.findElement(bunsTab).click();
        waitForBunsTabActive();
    }

    @Step("Перейти к разделу Соусы")
    public void goToSauces() {
        driver.findElement(saucesTab).click();
        waitForSaucesTabActive();
    }

    @Step("Перейти к разделу Начинки")
    public void goToFillings() {
        driver.findElement(fillingsTab).click();
        waitForFillingsTabActive();
    }

    @Step("Дождаться активности кнопки Булки")
    private void waitForBunsTabActive() {
        wait.until(ExpectedConditions.attributeContains(bunsTab, "class", "tab_tab_type_current"));
    }
    @Step("Дождаться активности кнопки Соусы")
    private void waitForSaucesTabActive() {
        wait.until(ExpectedConditions.attributeContains(saucesTab, "class", "tab_tab_type_current"));
    }
    @Step("Дождаться активности кнопки Начинки")
    private void waitForFillingsTabActive() {
        wait.until(ExpectedConditions.attributeContains(fillingsTab, "class", "tab_tab_type_current"));
    }


    @Step("Проверить, активен ли раздел Булки")
    public boolean isBunsTabActive() {
        return driver.findElement(bunsTab).getAttribute("class").contains("tab_tab_type_current");
    }

    @Step("Проверить, активен ли раздел Соусы")
    public boolean isSaucesTabActive() {
        return driver.findElement(saucesTab).getAttribute("class").contains("tab_tab_type_current");
    }

    @Step("Проверить, активен ли раздел Начинки")
    public boolean isFillingsTabActive() {
        return driver.findElement(fillingsTab).getAttribute("class").contains("tab_tab_type_current");
    }

}




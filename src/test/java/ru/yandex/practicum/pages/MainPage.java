package ru.yandex.practicum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

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
    }

    @Step
    public void open() {
        driver.get(BASE_URL);
    }

    @Step
    public void clickLoginButtonMain() {
        driver.findElement(loginButtonMain).click();
    }

    @Step
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }


    //    Конструктор
    @Step
    public void goToBuns() {
        driver.findElement(bunsTab).click();
    }

    @Step
    public void goToSauces() {
        driver.findElement(saucesTab).click();
    }

    @Step
    public void goToFillings() {
        driver.findElement(fillingsTab).click();
    }


    @Step
    public boolean isBunsTabActive() {
        return driver.findElement(bunsTab).getAttribute("class").contains("tab_tab_type_current");
    }

    @Step
    public boolean isSaucesTabActive() {
        return driver.findElement(saucesTab).getAttribute("class").contains("tab_tab_type_current");
    }

    @Step
    public boolean isFillingsTabActive() {
        return driver.findElement(fillingsTab).getAttribute("class").contains("tab_tab_type_current");
    }

    public By getBunsTabLocator() {
        return bunsTab;
    }

    public By getSaucesTabLocator() {
        return saucesTab;
    }

    public By getFillingsTabLocator() {
        return fillingsTab;
    }
}




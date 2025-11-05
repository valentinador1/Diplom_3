package ru.yandex.practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    //кнопка Войти в аккаунт
    private By loginButtonMain = By.xpath("//button[text()='Войти в аккаунт']");

    //кнопка Личный кабинет
    private By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']/ancestor::a");


//    private By buns = By.xpath("//span[text()='Булки']");

    private By buns = By.xpath("//h1[text()='Соберите бургер']/following-sibling::div/div");
    private By sauces = By.xpath("//span[text()='Соусы']");
    private By fillings = By.xpath("//span[text()='Начинки']");

    private final String BASE_URL = "https://stellarburgers.education-services.ru/";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void clickLoginButtonMain() {
        driver.findElement(loginButtonMain).click();
    }

    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    // Конструктор
    public void goToBuns() {
        driver.findElement(buns).click();
    }

    public void goToSauces() {
        driver.findElement(sauces).click();
    }

    public void goToFillings() {
        driver.findElement(fillings).click();
    }
}




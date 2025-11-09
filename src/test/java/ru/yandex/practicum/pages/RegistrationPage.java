package ru.yandex.practicum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private WebDriver driver;


    //поле Имя
    private By nameField = By.name("name");

    //поле email
    private By emailField = By.xpath("//label[normalize-space(text())='Email']/following-sibling::input");

    //поле Пароль
    private By passwordField = By.xpath("//label[normalize-space(text())='Пароль']/following-sibling::input");

    //кнопка зарегистрироваться
    private By registerButton = By.xpath("//button[text()='Зарегистрироваться']");

    //кнопка войти
    private By loginButton = By.xpath("//a[normalize-space(text())='Войти']");


    private By errorMessage = By.className("input__error");


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registerUser(String name, String email, String password) {


    }

    @Step
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    @Step
    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step
    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    @Step
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    @Step
    public void clickLogButton() {
        driver.findElement(loginButton).click();
    }
}
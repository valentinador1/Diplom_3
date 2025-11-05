package ru.yandex.practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    //поле email
    private By emailField = By.xpath("//label[normalize-space(text())='Email']/following-sibling::input");

    //поле Пароль
    private By passwordField = By.xpath("//label[normalize-space(text())='Пароль']/following-sibling::input");

    //кнопка Войти
    private By loginButton = By.xpath("//button[text()='Войти']");

    //кнопка Зарегистрироваться
    private By registerButton = By.xpath("//a[text()='Зарегистрироваться']");

    //кнопка Восстановить пароль
    private By forgotPasswordButton = By.xpath("//a[text()='Восстановить пароль']");

    //кнопка Войти по восстановлению пароля
    private By loginForgotPasswordButton = By.xpath("//a[@class='Auth_link__1fOlj' and normalize-space(text())='Войти']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void clickForgotPasswordButton() {
        driver.findElement(forgotPasswordButton).click();
    }

    public void clickLoginForgotPasswordButton() {
        driver.findElement(loginForgotPasswordButton).click();
    }
}

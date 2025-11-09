package ru.yandex.practicum.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.practicum.model.User;
import ru.yandex.practicum.pages.LoginPage;
import ru.yandex.practicum.pages.MainPage;
import ru.yandex.practicum.pages.RegistrationPage;
import ru.yandex.practicum.steps.UserSteps;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationTests extends BaseTest {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private User user;
    private UserSteps userSteps = new UserSteps();
    private String accessToken;


    @Before
    public void setUp() {
        driver = driverFactory.getDriver();
        user = new User();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);

        user.setName(RandomStringUtils.randomAlphabetic(12));
        user.setEmail(RandomStringUtils.randomAlphabetic(12) + "@mail.ru");
        user.setPassword(RandomStringUtils.randomAlphabetic(12));

    }


    @Test
    public void successfulRegistration() {

        mainPage.open();
        mainPage.clickLoginButtonMain();
        loginPage.clickRegisterButton();

        registrationPage.setName(user.getName());
        registrationPage.setEmail(user.getEmail());
        registrationPage.setPassword(user.getPassword());
        registrationPage.clickRegister();

        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Войти']"));
        assertTrue(loginButton.isDisplayed());

    }


    @Test
    public void registrationWithShortPassword() {
        mainPage.open();
        mainPage.clickLoginButtonMain();
        loginPage.clickRegisterButton();

        registrationPage.setName(user.getName());
        registrationPage.setEmail(user.getEmail());
        registrationPage.setPassword("123");
        registrationPage.clickRegister();

        assertEquals("Некорректный пароль", registrationPage.getErrorMessage());
    }


    @After  //удаляем пользователя через апи,тк не предусмотрено удаление черещ ui
    public void tearDown() {

        accessToken =
                userSteps.loginUser(user)
                        .extract()
                        .path("accessToken");


        if (accessToken != null) {
            userSteps.deleteUser(accessToken)
                    .statusCode(202);

        }

    }
}
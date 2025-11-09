package ru.yandex.practicum.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.model.User;
import ru.yandex.practicum.pages.LoginPage;
import ru.yandex.practicum.pages.MainPage;
import ru.yandex.practicum.pages.RegistrationPage;
import ru.yandex.practicum.steps.UserSteps;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;

public class LoginTests extends BaseTest {

    private static final Log log = LogFactory.getLog(LoginTests.class);
    @Rule
    public DriverFactory driverFactory = new DriverFactory();
    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private User user;
    private UserSteps userSteps = new UserSteps();
    private String accessToken;
    private RegistrationPage registrationPage;

    @Before
    public void setUp() {
        driver = driverFactory.getDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);

        user = new User();
        user.setName(RandomStringUtils.randomAlphabetic(12));
        user.setEmail(RandomStringUtils.randomAlphabetic(12) +"@mail.ru");
        user.setPassword(RandomStringUtils.randomAlphabetic(12));

        accessToken =
                userSteps.createUser(user)
                        .statusCode(200)
                        .body("success", is(true))
                        .extract()
                        .path("accessToken");
    }

    @Test
    public void loginViaMainButton() {
        mainPage.open();
        mainPage.clickLoginButtonMain();
        loginPage.setEmail(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.clickLoginButton();

        assertTrue(driver.findElement(By.xpath("//button[text()='Оформить заказ']")).isDisplayed());
    }

    @Test
    public void loginViaPersonalAccount() {
        mainPage.open();
        mainPage.clickPersonalAccountButton();
        loginPage.setEmail(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.clickLoginButton();
        assertTrue(driver.findElement(By.xpath("//button[text()='Оформить заказ']")).isDisplayed());
    }


    @Test
    public void loginViaRegisterButton() {
        mainPage.open();
        mainPage.clickLoginButtonMain();
        loginPage.clickRegisterButton();
        registrationPage.clickLogButton();
        loginPage.setEmail(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.clickLoginButton();
        assertTrue(driver.findElement(By.xpath("//button[text()='Оформить заказ']")).isDisplayed());
    }

    @Test
    public void loginViaForgotPasswordButton() {
        mainPage.open();
        mainPage.clickLoginButtonMain();
        loginPage.clickForgotPasswordButton();
        loginPage.clickLoginForgotPasswordButton();
        loginPage.setEmail(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.clickLoginButton();
        assertTrue(driver.findElement(By.xpath("//button[text()='Оформить заказ']")).isDisplayed());
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            userSteps.deleteUser(accessToken)
                    .statusCode(202);
        }
    }
}

package ru.yandex.practicum.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.practicum.pages.MainPage;
import java.time.Duration;


public class ConstructorTests extends BaseTest {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();
    private WebDriver driver;
    private MainPage mainPage;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = driverFactory.getDriver();
        mainPage = new MainPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void navigateConstructorSectionsFromBunsToSauces() {
        mainPage.open();

        mainPage.goToSauces();


        wait.until(ExpectedConditions.attributeContains(
                mainPage.getSaucesTabLocator(), "class", "tab_tab_type_current"));


        boolean expected = true;
        boolean actual = mainPage.isSaucesTabActive();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void navigateConstructorSectionsFromSaucesToFillings() {
        mainPage.open();


        mainPage.goToFillings();


        wait.until(ExpectedConditions.attributeContains(
                mainPage.getFillingsTabLocator(), "class", "tab_tab_type_current"));


        boolean expected = true;
        boolean actual = mainPage.isFillingsTabActive();
        Assert.assertEquals(expected, actual);
    }

}

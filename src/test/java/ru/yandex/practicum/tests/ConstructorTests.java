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


    @Before
    public void setUp() {
        driver = driverFactory.getDriver();
        mainPage = new MainPage(driver);
    }

    @Test
    public void navigateConstructorSectionsFromBunsToSauces() {
        mainPage.open();

        mainPage.goToSauces();

        boolean expected = true;
        boolean actual = mainPage.isSaucesTabActive();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void navigateConstructorSectionsFromSaucesToFillings() {
        mainPage.open();

        mainPage.goToFillings();

        boolean expected = true;
        boolean actual = mainPage.isFillingsTabActive();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void navigateConstructorFromFillingsToBuns() {
        mainPage.open();
        mainPage.goToFillings();
        mainPage.goToBuns();

        boolean expected = true;
        boolean actual = mainPage.isBunsTabActive();
        Assert.assertEquals(expected, actual);
    }

}

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
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }


    @Test
    public void navigateConstructorSections1() {
        mainPage.open();

        mainPage.goToSauces();

        By saucesTab = By.xpath("(//div[contains(@class,'tab_tab__1SPyG')])[2]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.attributeContains(saucesTab, "class", "tab_tab_type_current"));

        String bunsClasses = driver.findElement(By.xpath("(//div[contains(@class,'tab_tab__1SPyG')])[1]")).getAttribute("class");
        String sausesClasses = driver.findElement(By.xpath("(//div[contains(@class,'tab_tab__1SPyG')])[2]")).getAttribute("class");
        String fillingsClasses = driver.findElement(By.xpath("(//div[contains(@class,'tab_tab__1SPyG')])[3]")).getAttribute("class");

        Assert.assertTrue(sausesClasses.contains("tab_tab_type_current"));

    }

    @Test
    public void navigateConstructorSections2() {

        mainPage.open();
        mainPage.goToFillings();

        By fillingsTab = By.xpath("(//div[contains(@class,'tab_tab__1SPyG')])[3]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.attributeContains(fillingsTab, "class", "tab_tab_type_current"));

        String fillingsClasses = driver.findElement(fillingsTab).getAttribute("class");

        Assert.assertTrue(fillingsClasses.contains("tab_tab_type_current"));

    }

}

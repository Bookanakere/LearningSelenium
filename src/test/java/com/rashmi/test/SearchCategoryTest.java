package com.rashmi.test;



import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

/**
 * @author rashmibookanakere
 *
 */
public class SearchCategoryTest {


    private WebDriver driver;
    private WebDriverWait waitTill;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        String baseUrl = "https://desidutchstore.nl/";

        driver.get(baseUrl);
        driver.manage().window().maximize();
        waitTill = new WebDriverWait(driver,10);

    }


    @Test
    public void test_2() {
        // Test for search category

        //clickElement(By.id("search-product-type"), waitTill);
        Select category = new Select(driver.findElement(By.id("search-product-type")));
        category.selectByVisibleText("snacks");
        clickElement(By.className("search-bar__submit"), waitTill);
        try {
            Thread.sleep(1800);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        WebElement collectionHeading = driver.findElement(By.xpath("//h1[contains(@class,'collection__title')]"));
        assertEquals(collectionHeading.getAttribute("innerHTML"),"Products for \"snacks\"");

    }

    private static void clickElement(By by, WebDriverWait webDriverWait) {

        WebElement element= webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
    }
    @After
    public void tearDown() {
        driver.close();

    }

}

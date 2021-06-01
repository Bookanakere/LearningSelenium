package com.rashmi.test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait waitTill;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        String baseUrl = "https://desidutchstore.nl/";

        driver.get(baseUrl);
        driver.manage().window().maximize();
        waitTill = new WebDriverWait(driver,10);

    }

    @After
    public void tearDown() {
        driver.close();

    }
}

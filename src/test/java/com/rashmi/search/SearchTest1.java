package com.rashmi.search;


import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author rashmibookanakere
 *
 */
class SearchTest1 {
	
	
	private WebDriver driver;
	private WebDriverWait waitTill;

	/**
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
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
	void test_1() {
		
		 
			
	 		 // Go to Snacks via search option and open in new window
	        clickElement(By.className("search-bar__input"),waitTill);
	        clickElement(By.xpath("//ul[contains(@class,'search-bar__menu-linklist')]//a[@href='/collections/snacks']"),waitTill);
	        try {
				Thread.sleep(1800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        WebElement collectionHeading = driver.findElement(By.xpath("//h1[contains(@class,'collection__title')]"));
	        assertEquals(collectionHeading.getAttribute("innerHTML"),"Snacks");
	   
	
	}
	
	@Test
	void test_2() {
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
	@AfterEach
	void tearDown() {
		driver.close();
		
	}

}

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
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

/**
 * @author rashmibookanakere
 *
 */
public class SearchTest {
	
	
	private WebDriver driver;
	private WebDriverWait waitTill;
	private Utilities utility;

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
		utility = new Utilities();
        
	}

	@Test
	public void test_1() {

	 		 // Go to Snacks via search option and open in new window
	        utility.clickElement(By.className("search-bar__input"),waitTill);
	        utility.clickElement(By.xpath("//ul[contains(@class,'search-bar__menu-linklist')]//a[@href='/collections/snacks']"),waitTill);
	        try {
				Thread.sleep(1800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        WebElement collectionHeading = driver.findElement(By.xpath("//h1[contains(@class,'collection__title')]"));
	        assertEquals(collectionHeading.getAttribute("innerHTML"),"Snacks");
	   
	
	}


	/*private static void findElement(By by, WebDriverWait webDriverWait) {

		WebElement element= webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
		WebElement collectionHeading = driver.findElement(By.xpath("//h1[contains(@class,'collection__title')]"));
	}
	*/

	@After
	public void tearDown() {
		driver.close();
		
	}

}

package com.rashmi.main;


import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class Main{


	public static void main(String[] args) {
		
        System.setProperty("webdriver.chrome.driver","chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    	
        String baseUrl = "https://desidutchstore.nl/";

        driver.get(baseUrl);
        
        String parentHandle = driver.getWindowHandle();
        
        WebDriverWait waitTill = new WebDriverWait(driver,10);

 		
        // Go to Snacks via search option and open in new window
        clickElement(By.className("search-bar__input"),waitTill);
        WebElement link = driver.findElement(By.xpath("//ul[contains(@class,'search-bar__menu-linklist')]//a[@href='/collections/snacks']"));
        Actions newwin = new Actions(driver);
        newwin.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
       
        
        //Focus on new window to continue the flow
        Set<String> allWinHandles = driver.getWindowHandles();
        
        allWinHandles.forEach((String winHandle)-> {
        	if(winHandle != parentHandle)
        		driver.switchTo().window(winHandle);
        });

  
         /********** Add product directly from main page, find form using sibling function *****************/
        
         clickElement(By.xpath("//a[@href='/collections/snacks/products/parle-g-big-799g']/following-sibling::div[contains(@class,'product-item__info')]/form[@action='/cart/add']"),waitTill);
         
        /********** Add product directly from main page, find form using sibling function *****************/
      
        
         
         //click on cart and checkout
         clickElement(By.xpath("//a[@href='/cart']"),waitTill);
         clickElement(By.name("checkout"), waitTill);
         
         
         //Enter details
         
         //WebElement inputEmail = driver.findElement(By.id("checkout_email_or_phone"));
         //inputEmail.sendKeys("abc@gmail.com");
         
         inputValues(By.id("checkout_email_or_phone"), waitTill, "abc@gmail.com");
         inputValues(By.id("checkout_shipping_address_last_name"), waitTill, "Sharma");
         inputValues(By.id("checkout_shipping_address_address1"), waitTill, "32, Groenlaan");
         inputValues(By.id("checkout_shipping_address_zip"), waitTill, "3245TS");
         inputValues(By.id("checkout_shipping_address_city"), waitTill, "Amstelveen");
         inputValues(By.id("checkout_shipping_address_phone"), waitTill, "631222333");
         clickElement(By.id("continue_button"), waitTill);
         

        try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
        driver.close();
        driver.switchTo().window(parentHandle);
        driver.close();
        //Adding this comment to learn the branching process
	}
	
	private static void clickElement(By by, WebDriverWait webDriverWait) { 
		
		WebElement element= webDriverWait.until(ExpectedConditions.elementToBeClickable(by));        
			element.click();
		
	}
	
	private static void inputValues(By by, WebDriverWait webDriverWait, String input) {
		WebElement element = webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
		element.sendKeys(input);
	}
	
	/*************** Reference Code *******************************
	
	 /* ***** wait*********
	 *        try {
			Thread.sleep(1800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      ******* wait ********
      *
      *
      ***** find an element and print its attributes******
      *   WebElement newElement = driver.findElement(By.xpath("//a[@href='/collections/snacks/products/parle-g-big-799g']"));
        System.out.println(newElement.getAttribute("innerHTML"));
      *
      * ***** find an element and print its attributes******
	 * 
	 */
	
	
}
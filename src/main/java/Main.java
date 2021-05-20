


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        
        WebDriverWait waitTill = new WebDriverWait(driver,10);

 		
        // Go to snacks via search option
        clickElement(By.className("search-bar__input"),waitTill);
        clickElement(By.xpath("//ul[contains(@class,'search-bar__menu-linklist')]//a[@href='/collections/snacks']"),waitTill);
        
        
 
        
        /* Option 1
        *******Add product directly from main page,  submit form using id *****
        **
         clickElement(By.id("product_form_id_6040900567190_collection-template"),waitTill);
        ****Add product directly from main page,  submit form using id ********
        */
        
        
        
        
        /* Option 2
         * 
         ********** Add product directly from main page, find form using sibling function *****************/
        
         clickElement(By.xpath("//a[@href='/collections/snacks/products/parle-g-big-799g']/following-sibling::div[contains(@class,'product-item__info')]/form[@action='/cart/add']"),waitTill);
         
       /********** Add product directly from main page, find form using sibling function *****************
       
      
       
        
        
        /* Option 3
         * *****First click on the product, then add to cart, form submission doesn't work here, so find button **********
         
        
        clickElement(By.xpath("//a[@href='/collections/snacks/products/parle-g-big-799g']"),waitTill);
        
        clickElement(By.xpath("//form[@id='product_form_6040900567190']//div[@class = 'product-form__payment-container']//button[@type='submit']"),waitTill);
        
        /*
         * *****First click on the product, then add to cart, form submission doesn't work here, so find button**********
         */
        
 	
         
         //click on cart and checkout
         clickElement(By.xpath("//a[@href='/cart']"),waitTill);
         clickElement(By.name("checkout"), waitTill);
         
         
         //Enter details
         
         //WebElement inputEmail = driver.findElement(By.id("checkout_email_or_phone"));
         //inputEmail.sendKeys("abc@gmail.com");
         
         inputValues(By.id("checkout_email_or_phone"), waitTill, "abc@gmail.com");
         

        try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
        driver.close();
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
	
	
	
	 * ***** wait*********
	 *        try {
			Thread.sleep(1800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      ******* wait ********
      *
      *
      *
      ***** find an element and print its attributes******
      *   WebElement newElement = driver.findElement(By.xpath("//a[@href='/collections/snacks/products/parle-g-big-799g']"));
        System.out.println(newElement.getAttribute("innerHTML"));
      *
      * ***** find an element and print its attributes******
      *  
	 * 
	 */
	
	
}
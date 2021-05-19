
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
    	
        String baseUrl = "https://desidutchstore.nl/";

        driver.get(baseUrl);
        
        WebDriverWait waitTill = new WebDriverWait(driver,10);

 		
        // Go to snacks via search option
        clickElement(By.className("search-bar__input"),waitTill);
        clickElement(By.xpath("//ul[contains(@class,'search-bar__menu-linklist')]//a[@href='/collections/snacks']"),waitTill);
        
        
    
        
        /* Option 1
        *******Add product directly from main page,  submit form using id *****
        **
        WebElement submit = driver.findElement(By.id("product_form_id_6040900567190_collection-template"));
        submit.click();
        *****Add product directly from main page,  submit form using id ********
        *
        */
        
        
        
        /* Option 2
         * 
         ********** Add product directly from main page, find form using sibling function *****************/
         
         WebElement submit = driver.findElement(By.xpath("//a[@href='/collections/snacks/products/parle-g-big-799g']/following-sibling::div/form[@action='/cart/add']"));
         submit.click();
       /********** Add product directly from main page, find form using sibling function *****************
       
      
       
        
        
        /* Option 3
         * *****First click on the product, then add to cart, form submission doesn't work here, so find button **********
         
        
        clickElement(By.xpath("//a[@href='/collections/snacks/products/parle-g-big-799g']"),waitTill);
        WebElement submit = driver.findElement(By.xpath("//form[@id='product_form_6040900567190']//div[@class = 'product-form__payment-container']//button[@type='submit']"));
        submit.click();
        
        /*
         * *****First click on the product, then add to cart, form submission doesn't work here, so find button**********
         */
        
        try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
        driver.close();
	}
	
	private static void clickElement(By by, WebDriverWait webDriverWait) { 
		
		WebElement returnClickElement= webDriverWait.until(ExpectedConditions.elementToBeClickable(by));        
			returnClickElement.click();
		
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
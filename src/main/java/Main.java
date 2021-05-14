
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

 		
        clickElement(By.className("search-bar__input"),waitTill);
        clickElement(By.xpath("//ul[contains(@class,'search-bar__menu-linklist')]//a[@href='/collections/snacks']"),waitTill);
 
	}
	
	private static void clickElement(By by, WebDriverWait webDriverWait) { 
		
		WebElement returnClickElement= webDriverWait.until(ExpectedConditions.elementToBeClickable(by));        
			returnClickElement.click();
		
	}
	
	
}
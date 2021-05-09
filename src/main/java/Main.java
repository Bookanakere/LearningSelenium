import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class Main{

	public static void main(String[] args) {
		
        System.setProperty("webdriver.chrome.driver","chromedriver");

		WebDriver driver = new ChromeDriver();
    	
        String baseUrl = "https://www.phptravels.net/";

        driver.get(baseUrl);
        
        WebDriverWait waitTill = new WebDriverWait(driver,10);

 		
        clickElement(By.id("dropdownLangauge"),waitTill);
        clickElement(By.id("en"),waitTill);
        clickElement(By.className("select2-input"), waitTill);
        
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        WebElement destination = driver.findElement(By.className("select2-input"));
        System.out.println(destination.getAttribute("innerHTML"));
        destination.sendKeys("Amsterdam");
        
  
		/*
		 * WebElement languageSwitcher=
		 * waitTillLanguage.until(ExpectedConditions.elementToBeClickable(By.id(
		 * "dropdownLangauge"))); languageSwitcher.click();
		 * 
		 * WebElement englishLanguage=
		 * waitTillLanguage.until(ExpectedConditions.elementToBeClickable(By.id("en")));
		 * englishLanguage.click();
		 */
 
	}
	
	private static void clickElement(By by, WebDriverWait webDriverWait) { 
		
		WebElement returnClickElement= webDriverWait.until(ExpectedConditions.elementToBeClickable(by));        
			returnClickElement.click();
		
	}
	
	
}
package com.rashmi.test;



import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;

/**
 * @author rashmibookanakere
 *
 */
public class SearchTest extends TestBase{


	@Test
	public void test_1() {

	 		 // Go to Snacks via search option and open in new window
	        Utilities.clickElement(By.className("search-bar__input"),waitTill);
	        Utilities.clickElement(By.xpath("//ul[contains(@class,'search-bar__menu-linklist')]//a[@href='/collections/snacks']"),waitTill);
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

}

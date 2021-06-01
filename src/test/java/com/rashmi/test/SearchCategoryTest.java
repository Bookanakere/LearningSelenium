package com.rashmi.test;



import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.assertEquals;

/**
 * @author rashmibookanakere
 *
 */
public class SearchCategoryTest extends TestBase {

    @Test
    public void test_2() {
        // Test for search category

        Select category = new Select(driver.findElement(By.id("search-product-type")));
        category.selectByVisibleText("snacks");
        Utilities.clickElement(By.className("search-bar__submit"), waitTill);
        try {
            Thread.sleep(1800);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        WebElement collectionHeading = driver.findElement(By.xpath("//h1[contains(@class,'collection__title')]"));
        assertEquals(collectionHeading.getAttribute("innerHTML"),"Products for \"snacks\"");

    }

}

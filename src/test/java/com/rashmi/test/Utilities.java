package com.rashmi.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {

    public static void clickElement(By by, WebDriverWait webDriverWait) {

        WebElement element= webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
    }
}

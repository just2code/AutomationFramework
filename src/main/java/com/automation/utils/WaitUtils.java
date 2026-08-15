package com.automation.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    private WebDriverWait wait;

    public WaitUtils(WebDriver driver,int timeout) {
        // initialize wait
    		this.wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
    }

    public WebElement waitForVisibility(By locator) {
        // implementation
    		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {
        
    		return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}

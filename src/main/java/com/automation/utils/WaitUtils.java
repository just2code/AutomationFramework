package com.automation.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    /*private WebDriverWait wait;
     

    public WaitUtils(WebDriver driver,int timeout) {
        // initialize wait
    		this.wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
    }*/
	
	private Wait<WebDriver> wait;
	
	public WaitUtils(WebDriver driver, int timeout)
	{
		this.wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
	}

    public WebElement waitForVisibility(By locator) {
        // implementation
    		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {
        
    		return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}

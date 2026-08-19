package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import com.automation.utils.WaitUtils;


public abstract class BasePage {
	
	protected WebDriver driver;
	protected WaitUtils waitUtils;
	protected By oneTrustAcceptButton = By.id("onetrust-accept-btn-handler"); 
	
	public BasePage(WebDriver driver, WaitUtils waitUtils)
	{
		this.driver=driver;
		this.waitUtils=waitUtils;
	}
	
	public void dismissCookieBannerIfPresent()
	{
		try {
			driver.findElement(oneTrustAcceptButton).click();
		}catch(TimeoutException e)
		{
			//This is left blank because the cookie button may or may not appear
			System.out.println("The cookie button is not present or clickable");
		}
	}

	
}

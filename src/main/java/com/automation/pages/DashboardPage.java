package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.automation.utils.WaitUtils;

public class DashboardPage extends BasePage{

	
	private	By welcome = By.cssSelector(".Heading1.Title.PH.OSInline");
	
	
	
	public DashboardPage(WebDriver driver, WaitUtils waitUtils)
	{
		super(driver,waitUtils);
	}
	
	public void validateDashboard()
	{
		//waitUtils.waitForClickable(oneTrustAccept).click();
		dismissCookieBannerIfPresent();
		String strWelcome = waitUtils.waitForVisibility(welcome).getText().split(" ")[0];
		Assert.assertEquals(strWelcome, "Welcome");
		
	}
	
	
	
	
	
	
	
}

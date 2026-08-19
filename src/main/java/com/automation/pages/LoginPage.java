package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.utils.WaitUtils;

public class LoginPage extends BasePage{
	
	private By username = By.id("Username");
    private By password = By.name("Password");
    private By loginButton = By.name("login");
    //private By oneTrustAcceptButton = By.id("onetrust-accept-btn-handler");

    public LoginPage(WebDriver driver,WaitUtils waitUtils)
	{
		super(driver,waitUtils);
	}
    
    public DashboardPage login(String username, String password)
    {	    	 
    		//waitUtils.waitForClickable(oneTrustAcceptButton).click();
    		dismissCookieBannerIfPresent();
	    	waitUtils.waitForVisibility(this.username).sendKeys(username);
	    	waitUtils.waitForVisibility(this.password).sendKeys(password);
	    	waitUtils.waitForClickable(loginButton).click();
	    	return new DashboardPage(driver,waitUtils);
    }

}

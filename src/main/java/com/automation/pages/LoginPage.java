package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.utils.WaitUtils;

public class LoginPage extends BasePage{
	
	private By username = By.name("username");
    private By password = By.name("password");
    private By loginButton = By.id("login");

    public LoginPage(WebDriver driver,WaitUtils waitUtils)
	{
		super(driver,waitUtils);
	}
    
    public void login(String username, String password)
    {	    	 
	    	waitUtils.waitForVisibility(this.username).sendKeys(username);
	    	waitUtils.waitForVisibility(this.password).sendKeys(password);
	    	waitUtils.waitForClickable(loginButton).click();
    }

}

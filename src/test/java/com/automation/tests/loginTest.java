package com.automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;

public class loginTest extends BaseTest{
	
	
	
	
	@Test
	public void validLogin()
	{		
		driver.get(configReader.get("baseUrl"));
		LoginPage loginPage = new LoginPage(driver,waitUtils);
		loginPage.login("test","test");
		
	}

}

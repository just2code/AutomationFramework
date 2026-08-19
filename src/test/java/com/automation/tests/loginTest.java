package com.automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.factory.DriverFactory;
import com.automation.pages.DashboardPage;
import com.automation.pages.LoginPage;

public class LoginTest extends BaseTest{	
	
	@Test
	public void validLogin()
	{		
		
		  driver.get(configReader.get("baseUrl")); driver.manage().window().maximize();
		  LoginPage loginPage = new LoginPage(driver,waitUtils);
		  DashboardPage dashboardPage = loginPage.login("Russia123","Test@123");	
		  dashboardPage.validateDashboard();
		
	}

}

package com.automation.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.base.BaseTest;
import com.automation.pages.DashboardPage;
import com.automation.pages.LoginPage;

public class LoginTest extends BaseTest{	
	
	@Test(dataProvider = "loginCredentials", dataProviderClass = LoginDataProvider.class)
	public void loginWithMultipleCredentials(String username, String password,boolean expectedSuccess)
	{		
		
		  driver.get(configReader.get("baseUrl")); driver.manage().window().maximize();
		  LoginPage loginPage = new LoginPage(driver,waitUtils);
		  DashboardPage dashboardPage = loginPage.login(username,password);	
		  
		  if(expectedSuccess)
		  {
			  Assert.assertEquals(dashboardPage.validateDashboard(), "Welcome");
			  System.out.println("Moved to dashboardPage");
		  }else
		  {
			  System.out.println("Failed to move to dashboardPage");
		  }
		  
		  //dashboardPage.expandPersonalDetails();
		  //We have initialized a protected softAssert in BaseTest call the object here
		  SoftAssert softAssert = new SoftAssert();
		  softAssert.assertTrue(dashboardPage.isLogoVisible(),"Logo is not visible");
		  softAssert.assertAll();
		  
		  
	}

}

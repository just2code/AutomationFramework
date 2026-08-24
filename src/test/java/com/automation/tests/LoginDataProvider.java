package com.automation.tests;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
	
	
	@DataProvider(name="loginCredentials",parallel=true)
	public static Object[][] getData()
	{
		return new Object[][] {{"Russia123","Test@123",true}};
	}
	

}

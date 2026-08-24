package com.automation.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class suiteHooks {
	
	@BeforeSuite(alwaysRun = true)
	public void runBefreSuite()
	{
		System.out.println("I run at before suite "+this.getClass().getCanonicalName());
	}
	
	@BeforeTest(alwaysRun=true)
	public void beforeTest()
	{
		System.out.println("I run before test "+this.getClass().getCanonicalName());
	}
	
	@AfterTest(alwaysRun=true)
	public void afterTest()
	{
		System.out.println("I run after test "+this.getClass().getCanonicalName());
	}
	
	@AfterSuite(alwaysRun=true)
	public void afterSuite()
	{
		System.out.println("I run after suite "+this.getClass().getCanonicalName());
	}


}

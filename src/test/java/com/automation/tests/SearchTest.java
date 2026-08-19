package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.base.BaseTest;

public class SearchTest extends BaseTest{
	
	@Test
	public void searchTest()
	{
		System.out.println("Search test | Thread : "+Thread.currentThread().getName()+" | Driver : "+driver);
		driver.get("https://www.yahoo.com");
	}

}

package com.automation.pages;

import org.openqa.selenium.WebDriver;

import com.automation.utils.WaitUtils;


public abstract class BasePage {
	
	protected WebDriver driver;
	protected WaitUtils waitUtils;
	
	public BasePage(WebDriver driver, WaitUtils waitUtils)
	{
		this.driver=driver;
		this.waitUtils=waitUtils;
	}

	
}

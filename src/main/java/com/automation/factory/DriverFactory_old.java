package com.automation.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory_old {	
	
	private static ThreadLocal<WebDriver> driver;
	
	public static WebDriver getBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			return   new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			return new FirefoxDriver();
		}else
		{
			throw new RuntimeException("Invalid browser");
		}		
	}
	
	
	public static WebDriver getDriver()
	{
		return driver.get();
	}
	
	public static void quitDriver()
	{
		driver.get().quit();
		driver.remove();
	}
	
	

}

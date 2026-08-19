package com.automation.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public final class DriverFactory {
	
	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	private DriverFactory()
	{
		
	}
	
	public static void initDriver(String browser)
	{
		if(browser==null||browser.isBlank())
		{
			throw new RuntimeException("browser name is empty");
		}
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver.set(new ChromeDriver());
		}else if(browser.equalsIgnoreCase("ie"))
		{
			driver.set(new InternetExplorerDriver());
		}else
		{
			throw new IllegalArgumentException("Unsupported browser "+browser);
		}
		
	}
	
	
	public static WebDriver getDriver()
	{
		return driver.get();
	}
	
	public static void quitDriver()
	{
		WebDriver webDriver= driver.get();
		if(webDriver!=null)
		{
			driver.get().quit();
			driver.remove();
		}
		
	}
	
	

}

package com.automation.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.automation.config.ConfigReader;
import com.automation.factory.DriverFactory;
import com.automation.pages.LoginPage;
import com.automation.utils.WaitUtils;

public abstract class BaseTest {
	
	protected WebDriver driver;
	protected WaitUtils waitUtils;
	protected ConfigReader configReader;
	@BeforeClass
	public void loadConfig()
	{
		configReader = ConfigReader.getInstance();		
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		String browser = configReader.get("browser");
		int timeout = Integer.valueOf(configReader.get("timeout"));
		DriverFactory.initDriver(browser);
		driver = DriverFactory.getDriver();
		waitUtils = new WaitUtils(driver,timeout);
	}
	
	@AfterMethod
	public void tearDown()
	{
		DriverFactory.quitDriver();
		
	}
	
	
	

}

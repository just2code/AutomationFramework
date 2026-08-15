package com.automation.tests;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginWaitTest {

	
	@Test
	public void loginTest()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
		waitAndFind(driver, By.id("username"), 5).sendKeys("tomsmith");
		waitAndFind(driver, By.id("password"), 5).sendKeys("SuperSecretPassword!");
		waitAndFind(driver, By.cssSelector("button[type='submit']"), 5).click();
		//waitAndFind(driver,By.className("flash success"),5).getText();
		waitAndFind(driver,By.cssSelector(".flash.success"),5).getText();
	}
	
	
	
	public WebElement waitAndFind(WebDriver driver, By locator, int timeoutSeconds)
	{
		Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeoutSeconds))
				.pollingEvery(Duration.ofMillis(300)).ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
		
		return fluentWait.until(ExpectedConditions.elementToBeClickable(locator));
	}

}

package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.automation.utils.WaitUtils;

public class DashboardPage extends BasePage{

	
	private	By welcome = By.cssSelector(".Heading1.Title.PH.OSInline");
	private By medicalLogo = By.xpath("//img[@src='/MpsPortalSilkWeb/img/MpsLogo.png?229']");
	private By personalDetailsExpand = By.xpath("//div[@id='wt216_wtMainContent_WebPatterns_wt193_block_wtColumn1_WebPatterns_wt190_block_wtAccordionItems_wt68_wtTitle']/following-sibling::div[contains(@class,'AccordionVertical___icon')]");
	
	
	
	public DashboardPage(WebDriver driver, WaitUtils waitUtils)
	{
		super(driver,waitUtils);
	}
	
	public String validateDashboard()
	{
		dismissCookieBannerIfPresent();
		return waitUtils.waitForVisibility(welcome).getText().split(" ")[0];		
	}
	
	public void expandPersonalDetails()
	{
		waitUtils.waitForClickable(personalDetailsExpand).click();
	}
	
	public boolean isLogoVisible()
	{
		return !driver.findElements(medicalLogo).isEmpty() && driver.findElement(medicalLogo).isDisplayed(); 		
	}
	
	
	
	
	
	
	
}

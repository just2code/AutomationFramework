package com.automation.listeners;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.factory.DriverFactory;

public class ScreenshotListener implements ITestListener{
	
	//create a variable that stores the location of screenshot directory
	private static final String SCREENSHOT_DIR = "testoutput/Screenshots";	
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		WebDriver driver = DriverFactory.getDriver();
		if(driver==null)
		{
			System.out.println("driver object not available for "+result.getName());
		}
		
		try 
		{
			//Create File Directory 
			Files.createDirectories(Paths.get(SCREENSHOT_DIR));
			
			//we need time stamp
			String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
			//we need file name
			String filename = result.getName()+"_"+timestamp+".png";
			//destination path
			Path destination = Paths.get(SCREENSHOT_DIR,filename);
			//capture the screenshot
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(source.toPath(),destination);
			System.out.println("Screenshot saved for "+result.getName()+" at "+destination);
			
		}catch(IOException e)
		{
			System.out.println("Screenshot for the test "+result.getName()+" not captured");
		}		
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("PASSED : "+result.getName());
	}
	
	@Override
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("SKIPPED : "+result.getName());
	}

}

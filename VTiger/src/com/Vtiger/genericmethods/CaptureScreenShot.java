package com.Vtiger.genericmethods;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;


public class CaptureScreenShot 
{
	public static void getScreenShot(WebDriver driver, String path) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File imgFrom = ts.getScreenshotAs(OutputType.FILE);
		File imgTo = new File(path);
		Files.copy(imgFrom, imgTo);

	}

}

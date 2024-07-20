package com.automation.hybridFramework.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.automation.hybridFramework.BaseClass;

public class ScreenshotUtilities extends BaseClass {
	public static String timeStamp=new SimpleDateFormat("yyyy.MM.DD.HH.mm.ss").format(new Date());
	
	public static void getscreenshot(String TestCaseName) throws IOException {
		
		TakesScreenshot screenprint = (TakesScreenshot) driver;
		File source = screenprint.getScreenshotAs(OutputType.FILE);
		String destn=System.getProperty("user.dir")+ "\\Screenshots\\" + TestCaseName + timeStamp + ".png";
		File destination = new File(destn);
		FileUtils.copyFile(source, destination);
		
	}
	
	
    public  static String getscreenshotpath(String TestCaseName) throws IOException {
		
		TakesScreenshot screenprint = (TakesScreenshot) driver;
		File source = screenprint.getScreenshotAs(OutputType.FILE);
		String destn=System.getProperty("user.dir")+ "\\Screenshots\\" + TestCaseName + timeStamp +".png";
		File destination = new File(destn);
		FileUtils.copyFile(source, destination);
		return destn;
		
	}
	
	

}

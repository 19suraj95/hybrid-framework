package com.automation.hybridFramework.RoughTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HandleSSLCert {

	public static void main(String[] args) {
// set desired capabilities		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setAcceptInsecureCerts(true);
// setting chrome options 		
		ChromeOptions options = new ChromeOptions();
		options.merge(dc);		
        //  or 
		options.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com");
		
		

	}

}

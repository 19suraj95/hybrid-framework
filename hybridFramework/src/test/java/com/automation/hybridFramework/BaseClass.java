package com.automation.hybridFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties objectRepo = new Properties();
	public static FileInputStream fis;
	public static DesiredCapabilities dc=new DesiredCapabilities();
	
	
//	@Parameters("browser")
	@BeforeTest
	public void setup() {

		if (driver == null) {

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\application.properties");
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\objectRepository\\baserepo.properties");
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			try {
				objectRepo.load(fis);
			} catch (IOException e) {
				
				e.printStackTrace();
			}

			if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
//				System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
//				Handling SSL Certificate 
				dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				ChromeOptions options=new ChromeOptions();
				options.merge(dc);
				driver = new ChromeDriver(options);
			} else if (config.getProperty("browser").equalsIgnoreCase("Firefox")) {
//				System.setProperty("webdriver.gecko.driver",
//						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
				dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				FirefoxOptions options=new FirefoxOptions();
				options.merge(dc);
				driver = new FirefoxDriver(options);
			} else if (config.getProperty("browser").equalsIgnoreCase("IE")) {

//				System.setProperty("webdriver.gecko.driver",
//						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
				dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				InternetExplorerOptions options=new InternetExplorerOptions();
				options.merge(dc);
				driver = new InternetExplorerDriver(options);
			}
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
		driver.get(config.getProperty("badsslUrl"));

	}
	
	@AfterTest
	public void tearDown() {

		if (driver!= null) {
			driver.quit();
		}

	}
	
	

}

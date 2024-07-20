package com.automation.hybridFramework.testcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class FailedTestRunner {
	
	@AfterTest
	public void runFailedTest() {
		String FailedtestXmlPath = "C:\\hybridFramework_workspace\\hybridFramework\\test-output\\testng-failed.xml";
		List<String> list= new ArrayList<String>();
		list.add(FailedtestXmlPath);
		TestNG obj = new TestNG();
		obj.setTestSuites(list);
		
		obj.run();
		
	}

}

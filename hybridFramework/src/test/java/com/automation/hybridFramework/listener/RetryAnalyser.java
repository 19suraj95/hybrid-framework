package com.automation.hybridFramework.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
	int count=0;
	int maxReTryCount=3;

	@Override
	public boolean retry(ITestResult result) {
		
		if (count<maxReTryCount) {
			count++;
			return true;
		}
		return false;
	}

}

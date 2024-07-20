package com.automation.hybridFramework.listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.annotations.ITestAnnotation;


public class RetryFailedTestListener implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		annotation.setRetryAnalyzer(com.automation.hybridFramework.listener.RetryAnalyser.class);
		
	}
	
	
	

}

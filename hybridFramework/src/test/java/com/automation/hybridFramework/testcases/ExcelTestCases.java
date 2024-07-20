package com.automation.hybridFramework.testcases;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.hybridFramework.utilities.ExcelUtilities;

  
public class ExcelTestCases {
	
	String readExcelFilePath = ".\\src\\test\\resources\\TestData\\testData.xlsx";
	String writeDataFilePath= ".\\src\\test\\resources\\TestData\\WriteData_Excel.xlsx";
	
//	@Test (priority=1 ,groups="Excel")
//	public void readallDatafromExcelTest() throws IOException {
//		System.out.println("***********Reading all the Data From Excel*******************");
//		ExcelUtilities.readAllDataFromExcel(readExcelFilePath);	
//	}
//	
//	@Test (priority=2 , groups="Excel")
//	public void readSingleDatafromExcelTest() throws IOException {
//		System.out.println("***********Reading Single Data From Excel*******************");
//		XSSFCell Data =ExcelUtilities.readsingleDataFromExcel(1,1 ,"testData");	
//		System.out.println("Data found : " + Data);
//	}
//	
//	@Test (priority=3 , groups="Excel")
//	public void writeDataintoExcelTest() throws IOException {
//		Object[][] empData ={ {"EmpID", "FName" ,"Lname"},
//	              { 1 , "Suraj" , "Kumar"},
//	              { 2 , "Rahul" , "Kumar" },
//	              { 3 , "Aryan" , "Kumar" } };
//		System.out.println("***************Writting Data into Excel**************");
//		ExcelUtilities.writemultipleDataIntoExcel(empData, "WriteData_Excel");
//		System.out.println("***************Reading Data from written Excel**************");
//		ExcelUtilities.readAllDataFromExcel(writeDataFilePath);
//		
//	}
//	@Test (priority=4 , groups="Excel")
//	public void updateSingleCellintoExistingExcelFile() throws IOException {
//		System.out.println("***************Updating Data into Excel**************");
//		ExcelUtilities.writeDataIntoSingleCellExcel("Aryan", 1, 1, "SingleCellData");
//		System.out.println("***************Reading Updated Data from Excel**************");
//		XSSFCell Data =ExcelUtilities.readsingleDataFromExcel(1, 1 ,"SingleCellData");
//		System.out.println("Data : "+ Data);
//		
//	}
//	
//	@Test (priority=5 , groups="Excel")
//	public void AddDataintoExistingExcelFile() throws IOException {
//		Object[][] data= { {3 , "Tes1" , "user"},
//		           {4 , "Tes2" , "user"},
//		           {5 , "Tes3" , "user"},};
//		System.out.println("***************Updating Data into Excel**************");
//		ExcelUtilities.addDataIntoExistingExcel(data, "WriteData_Excel");
//		System.out.println("***************Reading Updated Data from Excel**************");
//		ExcelUtilities.readAllDataFromExcel("WriteData_Excel");
//	}
//	
//	
//	// Data Provider Test
//	
//	@Test(dataProvider="Login Data" , priority=6 , groups="DataProvider" ,description = "This is Data Provder Test")
//	public void validateDataProvider(String Email , String Name , String Pass) {
//		
//		System.out.println(Email+" : "+ Name+" :  "+Pass);
//		
//	}
//	
//	@DataProvider(name="Login Data")
//	public static String [][] getData(){
//		
//		String[][] data = { 
//				{"test1@gmail.com", "skumar1", "Pwd"},
//				{"test1@gmail.com", "skumar1", "Pwd"},
//				{"test1@gmail.com", "skumar1", "Pwd"},};
//			
//		return data;
//		
//	}

}

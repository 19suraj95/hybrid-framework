package com.automation.hybridFramework.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtilities {
//	static String excel_testData = ".\\src\\test\\resources\\TestData\\testData.xlsx";
	
	public static void readAllDataFromExcel(String fileName) throws IOException {
		String path = ".\\src\\test\\resources\\TestData\\"+fileName+".xlsx";
		FileInputStream inputStream = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet =workbook.getSheetAt(0);
	//	XSSFSheet sheet =workbook.getSheet("Sheet1");  // we can access sheet by sheet name as well
		int NoOfRows =sheet.getLastRowNum();
		int NoOfcolumns =sheet.getRow(1).getLastCellNum();
//  Using iterating Row and cell using For Loop
		for (int r=0 ; r<=NoOfRows ; r++) {
			XSSFRow row	=sheet.getRow(r);
			
			for (int c =0 ; c<NoOfcolumns ; c++) {
				XSSFCell col =row.getCell(c);
				
			   switch(col.getCellType()) 
			   {
				   case STRING : System.out.print(col.getStringCellValue());
				   break;
				   case NUMERIC : System.out.print(col.getNumericCellValue());
				   break;
				   case BOOLEAN : System.out.print(col.getBooleanCellValue());
				   break;
	
			   }
			   System.out.print(" | ");
					
			}
			System.out.println();	
		}		
	} 
	
	public static XSSFCell readsingleDataFromExcel(int row , int col , String fileName) throws IOException {
		String path = ".\\src\\test\\resources\\TestData\\"+fileName+".xlsx";
		FileInputStream inputStream = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet =workbook.getSheetAt(0);
	//	XSSFSheet sheet =workbook.getSheetAt("Sheet1");  // we can access sheet by sheet name as well
		XSSFRow rownum =sheet.getRow(row);
		XSSFCell colnum =rownum.getCell(col);
		return colnum;
	}
	
	public static void writemultipleDataIntoExcel(Object[][] empData,String fileName) throws IOException {
		String filePath=".\\src\\test\\resources\\TestData\\"+fileName+".xlsx";
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet();
		
//		Object[][] empData ={ {"EmpID", "FName" ,"Lname"},
//				              { 1 , "Suraj" , "Kumar"},
//				              { 2 , "Rahul" , "Kumar" },
//				              { 3 , "Aryan" , "Kumar" } };
		
		int rownum= empData.length;
		int colnum= empData[0].length;
		
		for(int r=0 ; r<rownum ;r++ ) {
			
			XSSFRow row=sheet.createRow(r);
			
			for (int c = 0 ;c<colnum ;c++) {
				
				XSSFCell col=row.createCell(c);
				Object value = empData[r][c];
				if(value instanceof String) {
					col.setCellValue((String)value);
					
				}else if (value instanceof Boolean) {
					col.setCellValue((Boolean)value);
				}else if (value instanceof Integer) {
					col.setCellValue((Integer)value);
				}
				
			}
		}
		
		
		
		FileOutputStream file = new FileOutputStream(filePath);
		workbook.write(file);
		file.close();
		
	}
	
    public static void writeDataIntoSingleCellExcel(Object data, int rowNum , int colNum ,String fileName) throws IOException {
	    String path = ".\\src\\test\\resources\\TestData\\"+fileName+".xlsx";
	    FileInputStream inputStream = new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
		XSSFSheet sheet=workbook.getSheetAt(0);
		int row= rowNum ;
		int col= colNum;
					
		XSSFRow rowNo=sheet.getRow(row);
	    XSSFCell colNo=rowNo.createCell(col);
	    			
	     		if(data instanceof String) {
	     			colNo.setCellValue((String)data);
					
				}else if (data instanceof Boolean) {
					colNo.setCellValue((Boolean)data);
				}else if (data instanceof Integer) {
					colNo.setCellValue((Integer)data);
				}
	     		
	     		
	   	inputStream.close(); 
	   	FileOutputStream outputstream = new FileOutputStream(path);
	   	workbook.write(outputstream);
	   	outputstream.close();
	   	
	
} 
    
    public static void addDataIntoExistingExcel(Object[][] data, String fileName) throws IOException {
    	int datarow=0;
	    String path = ".\\src\\test\\resources\\TestData\\"+fileName+".xlsx";
	    FileInputStream inputStream = new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
		XSSFSheet sheet=workbook.getSheetAt(0);
		int row= sheet.getLastRowNum();
		int col = data[0].length;
		int row1=0;
		
        for(int r=row+1 ; r<=row+data.length ;r++ ) {
        	
			XSSFRow rownum=sheet.createRow(r);
			
			for (int c = 0 ;c<col ;c++) {
				XSSFCell colnum=rownum.createCell(c);
				Object value = data[datarow][c];
				if(value instanceof String) {
					colnum.setCellValue((String)value);
					
				}else if (value instanceof Boolean) {
					colnum.setCellValue((Boolean)value);
				}else if (value instanceof Integer) {
					colnum.setCellValue((Integer)value);
				}
				
			}
			datarow++;
		} 		
	   	inputStream.close(); 
	   	FileOutputStream outputstream = new FileOutputStream(path);
	   	workbook.write(outputstream);
	   	outputstream.close();
	   	
	
   }
	
	public static void readDatafromDatabaseandWriteIntoExcel(String dbConString ,String userName , String password , String fileName ,String Query) throws SQLException, IOException {
		String path = ".\\src\\test\\resources\\TestData\\"+fileName+".xlsx";
		String DBConString=dbConString;
	//	Setup Connection to DB
		Connection con = DriverManager.getConnection(DBConString, userName, password);
		Statement stmt= con.createStatement();
	//	Executing Sql Query and string result into resultset
		ResultSet result=stmt.executeQuery(Query);
		
	// Code to write the data in excel
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet =workbook.createSheet("User Data");
		XSSFRow row=sheet.createRow(0);
		row.createCell(0).setCellValue("First Name");
		row.createCell(1).setCellValue("Last Name");
		row.createCell(2).setCellValue("User ID");
		
		int r=1; // need to start with 1 as 0th row already created with field name above
		while(result.next()) {
		// Storing data from resultset to local variable
			String Fname=result.getString("Fname");
			String Lname=result.getString("Lname");
			String userID=result.getString("Userid");
		// storing data to excel from 2nd row   
			row =sheet.createRow(r++);
		    row.createCell(0).setCellValue(Fname);
		    row.createCell(1).setCellValue(Lname);
		    row.createCell(2).setCellValue(userID);
		   	
		}
		FileOutputStream outputstream= new FileOutputStream(path);
		workbook.write(outputstream);
		outputstream.close();
		con.close();
		
	}
	
	public static void readDataFromExcelAndWiteIntoDB(String fileName , String dbConString ,String userName , String password) throws SQLException, IOException {
		String path = ".\\src\\test\\resources\\TestData\\"+fileName+".xlsx";
		FileInputStream inputstream = new FileInputStream(path);
		Connection con=DriverManager.getConnection(dbConString,userName,password);
		Statement stmt = con.createStatement();
		stmt.execute("Create Table Query");
		
		
		//Reading Data from Excel 
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		XSSFSheet sheet=workbook.getSheetAt(0);
		int rows = sheet.getLastRowNum();
		
		for (int r=0 ; r<rows ; r++) {
		  XSSFRow row= sheet.createRow(r);
		  
	//	  lets Say we have 5 column in Excel
		 String FirstName= row.getCell(0).getStringCellValue();
		 String LastName= row.getCell(1).getStringCellValue();
		 String UserID= row.getCell(2).getStringCellValue();
		 String sql = "Insert Into tableA values ('"+FirstName+"' , '"+LastName+"' , '"+LastName+"' , '"+UserID+"')";
		 stmt.execute(sql);
		 stmt.execute("commit");
		 	
		}
		
	   workbook.close();
	   inputstream.close();
	   con.close();
		
	}	
	
}

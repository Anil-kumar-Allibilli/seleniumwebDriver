package day40Excel;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcel 
{
	public static void main(String[]  args) throws IOException
	{
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\TestDataFolder\\writeExcel.xlsx");
		XSSFWorkbook newworkBook = new XSSFWorkbook();
		XSSFSheet sheetname = newworkBook.createSheet("Data");
		
		//create data in row and column
		XSSFRow row1 = sheetname.createRow(0);
		row1.createCell(0).setCellValue("Welcome");
		row1.createCell(1).setCellValue("123");
		row1.createCell(2).setCellValue("test");
		row1.createCell(3).setCellValue("Selenium");
		
		
		XSSFRow row2 = sheetname.createRow(1);
		row2.createCell(0).setCellValue("WelcomeR1");
		row2.createCell(1).setCellValue("C123R1");
		row2.createCell(2).setCellValue("CtestR1");
		row2.createCell(3).setCellValue("CSeleniumR1");
		
		XSSFRow row3 = sheetname.createRow(2);
		row3.createCell(0).setCellValue("CWelcomeR2");
		row3.createCell(1).setCellValue("C123R2");
		row3.createCell(2).setCellValue("CtestR2");
		row3.createCell(3).setCellValue("CSeleniumR2");
		
		newworkBook.write(file);
		System.out.println("file created");
		newworkBook.close();
		file.close();
	}
}

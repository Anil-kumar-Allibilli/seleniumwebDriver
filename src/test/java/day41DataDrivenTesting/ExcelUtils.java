package day41DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils 
{

	/*Utility is the class which will have common methods in it
	 Data driven testing the testing where we will create a test data like (Excel, CSV, DB, JSON, etc.) file and use in the automation
	 
	 Data Driven Testing is a testing approach where test logic is separated from test data.

	Instead of hardcoding inputs in your test scripts, you store them in external files (Excel, CSV, XML, JSON, databases).

	The automation framework reads these values at runtime and executes the same test case with multiple sets of data.
	 */
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style; //used to appy styles to cells
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException
	{
		fi = new FileInputStream(xlfile);	
		wb =  new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int rowCount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowCount;
	}
	
	public static int getCellCount(String xlfile, String xlsheet,int rowNum) throws IOException
	{
		fi = new FileInputStream(xlfile);	
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int cellCount = ws.getRow(rowNum).getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;
	}
	
	public static String getCellData(String xlfile, String xlsheet,int rowNum, int colNum) throws IOException
	{
		fi = new FileInputStream(xlfile);	
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row= ws.getRow(rowNum);
		cell = row.getCell(colNum);
		
		String data;
		try
		{
			//data = cell.toString(); // convert cell data to steing or else we have another class of apachi called DataFormatter which is ued to covert the data format
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell); //used to change the value to string reagardless of cell type
		}
		catch(Exception  e)
		{
			data = "";
		}
		
		
		
	/*
	 * another way of handling cell data for all types of data types
	 String data;
    try {
        // Handle different cell types
        switch (cell.getCellType()) {
            case STRING:
                data = cell.getStringCellValue();
                break;
            case NUMERIC:
                data = String.valueOf((int)cell.getNumericCellValue());
                break;
            case BOOLEAN:
                data = String.valueOf(cell.getBooleanCellValue());
                break;
            case BLANK:
                data = "";
                break;
            default:
                data = "";
        }
    } catch (Exception e) {
        data = "";
    }
	 */
		
		
		wb.close();
		fi.close();
		return data;
	}
	
	
	public static void setCellData(String xlfile, String xlsheet,int rowNum, int colNum, String data) throws IOException
	{
		fi = new FileInputStream(xlfile);	 // Step 1: Open Excel file
		wb = new XSSFWorkbook(fi);			// Step 2: Load workbook
		ws = wb.getSheet(xlsheet);		// Step 3: Get sheet
		row= ws.getRow(rowNum);			// Step 4: Get row
		cell = row.createCell(colNum);  // Step 5: Create/overwrite cell
		cell.setCellValue(data);    	 // Step 6: Set new value
		
		fo = new FileOutputStream(xlfile); // Step 7: Open file for writing
		wb.write(fo);						// Step 8: Write updated workbook back to file	
		wb.close();
		fi.close();
		fo.close();
	}
	public static void fullGreenColout(String xlfile, String xlsheet,int rowNum, int colNum) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(colNum);
		
		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		
		cell.setCellStyle(style);
		fo = new FileOutputStream(xlfile); // Step 7: Open file for writing
		wb.write(fo);						// Step 8: Write updated workbook back to file	
		wb.close();
		fi.close();
		fo.close();
		
	}
	
	public static void fullRedColout(String xlfile, String xlsheet,int rowNum, int colNum) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(colNum);
		
		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		
		cell.setCellStyle(style);
		fo = new FileOutputStream(xlfile); // Step 7: Open file for writing
		wb.write(fo);						// Step 8: Write updated workbook back to file	
		wb.close();
		fi.close();
		fo.close();
		
	}
}

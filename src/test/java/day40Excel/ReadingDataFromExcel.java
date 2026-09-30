package day40Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	
	/*
	 to use excel data in the automation we need to use mvn repository called Apache POI which helps in readying excel
	 we need to get dependencies of
	 1) Apache Poi Common
		 <!-- Source: https://mvnrepository.com/artifact/org.apache.poi/poi -->
			<dependency>
			    <groupId>org.apache.poi</groupId>
			    <artifactId>poi</artifactId>
			    <version>5.5.1</version>
			    <scope>compile</scope>
			</dependency>
	2) Apache POI API Based On OPC and OOXML Schemas » 5.5.1
		<!-- Source: https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
		<dependency>
		    <groupId>org.apache.poi</groupId>
		    <artifactId>poi-ooxml</artifactId>
		    <version>5.5.1</version>
		    <scope>compile</scope>
		</dependency>

flow of excel hirarchy : ExcelFile ---> WorkBook ------> Sheet -------> Rows ------> Cells


  FileInputStream - for reading from excel
  FileOutputStream - to write in excel
  
  classes used to work with excel:
  1) XSSFWorkbook --------- workbook
  2) XSSFSheet --------- Sheet
  3) XSSFRow --------- Row
  4) XSSFCell --------- Cell
	 */
	public static void main(String[] args) throws IOException 
	{
		
		FileInputStream file = new FileInputStream("C:\\Workspaces\\SeleniumWebDriver\\seleniumwebDriver\\TestDataFolder\\excelData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		//get number of rows 
		int totalRows = sheet.getLastRowNum();
		int totalCells = sheet.getRow(1).getLastCellNum(); //5
		System.out.println("number of rows: " +totalRows); //4
		System.out.println("number of cells: " +totalCells);
		
		for(int row=0;row<=totalRows;row++)
		{
			XSSFRow currentRow = sheet.getRow(row);
			for(int col=0;col<totalCells;col++)
			{
				XSSFCell cellCol = currentRow.getCell(col);// here tostring gets data from
				System.out.print(cellCol.toString()+"\t");
			}
			System.out.println();
		}
		workbook.close();
		file.close();
	}

}

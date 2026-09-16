package day32Table;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.manage().window().maximize();
		
		//find number of rows in a table
		int rowCount = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr")).size();
		System.out.println("Number of rows: " +rowCount);
		
		//read data from table
		String bookname = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[5]/td[1]")).getText();
		System.out.println(bookname);
		
		//find numerr of columns
		int col = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//th")).size();
		System.out.println("number of column: " +col);
		
		//find data form all Rows and Columns
//		for(int r=2;r<=rowCount;r++)
//		{
//			for(int c=1;c<=col;c++)
//			{
//				String text = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td["+c+"]")).getText();
//				System.out.println(text+ "\t"); // here \t give tab after giving text
//			}
//		}
		
		
		//get list of authors
		for(int r=2;r<=rowCount;r++)
		{
			String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[2]")).getText();
			//System.out.println("Writer name: " +author);
			if(author.equals("Mukesh"))
			{
				String boolname = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[2]/td[1]")).getText();
				System.out.println(author+ ":" +bookname);
			}
		}
	}

}

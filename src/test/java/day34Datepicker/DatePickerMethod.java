package day34Datepicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerMethod {
	
	static void selectFutureMonthDateYear(WebDriver driver,String month,String year,String date)
	{
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("09/01/2026"); // mm/dd/yyyy
		driver.findElement(By.xpath("//input[@id='datepicker']")).click(); //open data picker
		
		while(true)
		{
			
			String selectedMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String selectedYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if(selectedMonth.equals(month) && selectedYear.equals(year))
			{
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); //click button for future datae
			//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //click button for past or old dates
		}
		
		//select date
		List<WebElement> ListoFDates = driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody//tr/td//a"));
		for(WebElement  selectedDate:  ListoFDates)
		{
			String correctDate = selectedDate.getText();
			if(correctDate.equals(date))
			{
				selectedDate.click();
				break;
			}
		
		}
	}
	
	static void selectPastMonthDateYear(WebDriver driver,String month,String year,String date)
	{
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("09/01/2026"); // mm/dd/yyyy
		driver.findElement(By.xpath("//input[@id='datepicker']")).click(); //open data picker
		
		while(true)
		{
			
			String selectedMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String selectedYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if(selectedMonth.equals(month) && selectedYear.equals(year))
			{
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //click button for past or old dates
		}
		
		//select date
		List<WebElement> ListoFDates = driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody//tr/td//a"));
		for(WebElement  selectedDate:  ListoFDates)
		{
			String correctDate = selectedDate.getText();
			if(correctDate.equals(date))
			{
				selectedDate.click();
				break;
			}
		
		}
	}
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		String month = "October";
		String date = "12";
		String year = "2023";
		//selectFutureMonthDateYear(driver, month, year,date);
		selectPastMonthDateYear(driver, month, year,date);

	}

}

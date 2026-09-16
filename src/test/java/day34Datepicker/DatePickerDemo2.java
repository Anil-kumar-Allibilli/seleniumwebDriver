package day34Datepicker;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerDemo2 
{ 
	static Month convertMonth(String month)
	{
		HashMap<String, Month> monthMap = new HashMap<String, Month>();
		monthMap.put("January", Month.JANUARY);
		monthMap.put("February", Month.FEBRUARY);
		monthMap.put("March", Month.MARCH);
		monthMap.put("April", Month.APRIL);
		monthMap.put("May", Month.MAY);
		monthMap.put("June", Month.JUNE);
		monthMap.put("July", Month.JULY);
		monthMap.put("August", Month.AUGUST);
		monthMap.put("September", Month.SEPTEMBER);
		monthMap.put("October", Month.OCTOBER);
		monthMap.put("November", Month.NOVEMBER);
		monthMap.put("December", Month.DECEMBER);
		
		Month vmonth = monthMap.get(month);
		if(vmonth == null)
		{
			System.out.println("Invalid month ......");
		}
		
		return vmonth;
	}

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.manage().window().maximize();
		
		//inputs 
		//current month = "April", then 
		// January < April (1<4) past(Expected month < current month)
		// June > April (6> 4) future(Expected month > current month)
		String requirtedYear = "2021";
		String requirtedMonth = "January";
		String requirtedDate = "12";
		
		driver.switchTo().frame("frame-one796456169");
		driver.findElement(By.xpath("//spam[@claas = 'icon_calender']")).click();
		
		//select year
		WebElement yearDropdown= driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select sc = new Select(yearDropdown);
		sc.selectByContainsVisibleText(requirtedYear);
		
		while(true)
		{
			//select month 
			String displayMonth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")).getText();
			
			//convert requiredMonth and currentMonth to Month object
			Month expectedmonth = convertMonth(requirtedMonth);
			Month currentmonth = convertMonth(displayMonth);
			
			//compare
			int result = expectedmonth.compareTo(currentmonth);
			// 0  month are equal 
			// >0 month is future month
			//<0 month is past month
			if(result < 0)
			{
				//past
				driver.findElement(By.xpath("//span[@class = 'ui-icon ui-icon-circle-triangle-w']")).click();
			}
			else if(result > 0) 
			{
				driver.findElement(By.xpath("//span[@class = 'ui-icon ui-icon-circle-triangle-e']")).click();

			}
			else
			{
				break;
			}
			
		}
		//date
		List<WebElement> datelist = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calender']//tbody//tr//td//a"));
		
		for(WebElement requiredate : datelist)
		{
			if(requiredate.getText().equals(requirtedDate))
			{
				requiredate.click();
				break;
			}
		}
		
	}

}

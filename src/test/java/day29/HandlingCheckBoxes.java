package day29;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCheckBoxes 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//select check box
		driver.findElement(By.xpath("//input[@id='sunday']")).click();
		List<WebElement> checkbox = driver.findElements(By.xpath("//div[@class=\"form-check form-check-inline\"]//input[@type=\"checkbox\" and @type=\"checkbox\"]"));
//		for(int i=0;i<checkbox.size();i++)
//		{
//			checkbox.get(i).click();
//		}
		//another way of loop
//		for(WebElement n : checkbox)
//		{
//			n.click();			
//		}
//		System.out.println(checkbox);
		
		//select last 3 check boxes:
		for(int i=checkbox.size()-1;i>=checkbox.size()-3 ;i-- )
		{
			checkbox.get(i).click();
		}
		
		//uncheck selected checkbox
		Thread.sleep(5000);
		for(WebElement unselect: checkbox) 
		{
			if(unselect.isSelected())
			{
				unselect.click();
			}
		}
	}
}

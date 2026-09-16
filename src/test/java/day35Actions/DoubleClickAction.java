package day35Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class DoubleClickAction {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		WebElement dcButton = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		Actions action = new Actions(driver);
		action.doubleClick(dcButton).perform();
		
		//save field1
		String field1 = driver.findElement(By.xpath("//input[@id='field1']")).getAttribute("value");
		System.out.println(field1);
		driver.findElement(By.xpath("//input[@id='field2']")).clear();
		driver.findElement(By.xpath("//input[@id='field2']")).sendKeys("WelCome");
		String field2 = driver.findElement(By.xpath("//input[@id='field2']")).getAttribute("value");
		if(field2.equals(field1))
		{
			System.out.println(field2+ " and " +field1+ " are same!");
		}
		else
		{
			System.out.println(field2+ " and " +field1+ " are not same!");
		}

	}

}

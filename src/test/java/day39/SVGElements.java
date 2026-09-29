package day39;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVGElements {

	//Selenium’s default locators often fail because of namespace differences.
	//Using XPath with local-name() --------> "//*[local-name()='svg']//*[local-name()='circle']"
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		driver.findElement(By.xpath("//a[normalize-space()='']//*[name()='svg']")).click();

	}

}

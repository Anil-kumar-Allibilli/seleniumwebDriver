package day35Actions;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction 
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		
		//mouser hover
		Actions action = new Actions(driver);
		driver.findElement(By.xpath("//span[normalize-space()='Account & Lists']")).isDisplayed();
		Thread.sleep(5000);
		
		// build() + perform() for chain of actions
		//action.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Account & Lists']"))).moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Your Account']"))).click().build().perform();  
		//build is used to create method, 
		//perform to finish the method (it has capability to build and perform), it internally has build 
		
		
		//for singe action perform();
		action.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Account & Lists']"))).perform();
		action.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Your Account']"))).click().perform();
		System.out.println("enecution completed");
		
		//Right click 
		
		
	}

}

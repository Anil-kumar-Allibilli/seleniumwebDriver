package day35Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickAction {

	public static void main(String[] args) 
	{

		WebDriver driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo/input.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		WebElement rcButton = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		
		
		//right click
		Actions action = new Actions(driver);
		action.contextClick(rcButton).perform();
		
		//click element
		driver.findElement(By.xpath("//input[@name='context-menu-input-name']")).sendKeys("input box in right click");

	}

}

package day36KeyBoardActions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenLinkInNewTab {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/#");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[@id='apple']")).sendKeys("asdf");
		Actions ac = new Actions(driver);
		WebElement apple = driver.findElement(By.xpath("//a[@id='apple']"));
		//control+ apple link
		ac.keyDown(Keys.CONTROL).click(apple).keyUp(Keys.CONTROL).perform();
		
		Set<String> windows = driver.getWindowHandles(); //set dont have get method so convert set to list
		List<String> listWindows = new ArrayList<>(windows);
		String applewindow = listWindows.get(1); // or driver.switchTo().window(listWindows.get(1))
		driver.switchTo().window(applewindow); 
	}

}

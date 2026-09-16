package day36KeyBoardActions;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver =new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/#");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		WebElement maximum = driver.findElement(By.xpath("//div[@id='HTML7']//span[2]"));
		System.out.println("Location of the max slider before moving" +maximum.getLocation()); //
		
		WebElement minimum = driver.findElement(By.xpath("//div[@id='HTML7']//span[1]"));
		System.out.println("Location of the min slider before moving" +minimum.getLocation()); //gets the location of the (x,y) location get.Location().getX() or getY();
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(maximum, 95, 0).perform(); //deanAndDropBy(Element,X,Y)
		System.out.println("Location of the max slider after moving" +maximum.getLocation());
		action.dragAndDropBy(minimum, -10, 0).perform();
		System.out.println("Location of the min slider after moving" +minimum.getLocation());
		System.out.println("check");

	}

}

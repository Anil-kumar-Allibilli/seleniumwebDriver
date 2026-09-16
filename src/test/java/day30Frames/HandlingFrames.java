package day30Frames;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames {

	public static void main(String[] args) 
	{
		//Frame inside the frame is called Iframe (one webpage having multiple webpages in it)
		//element side the Iframes are not possible to interact so we have to switchTo Iframs then interact with the elements 
		
		// how to switch 1) //driver.switchTo().frames(name) or //driver.switchTo().frames(id) or //driver.switchTo().frames(WebElement) or //driver.switchTo().frames(index)
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		//Frame1
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src=\"frame_1.html\"]"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Welcome Anil");
		driver.switchTo().defaultContent(); // it will help in coming out of the Iframes, go back to the page
		
		//Frame2
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src=\"frame_2.html\"]"));
		driver.switchTo().frame(frame2);  // if we have ID of the tag then we can write "driver.switchTo().frame("ID Name");"
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Welcome to frame2");
		driver.switchTo().defaultContent();
		
		//Frame3
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src=\"frame_3.html\"]"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Welcome to frame3");
		//inner frame - Frame3
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']")).click();
		driver.switchTo().defaultContent();
		
		//JS click
		WebElement jsButton = driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", jsButton);
		driver.switchTo().defaultContent();

	}

}

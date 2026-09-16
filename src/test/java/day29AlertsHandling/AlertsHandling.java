package day29AlertsHandling;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AlertsHandling {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		//simple alers - OK button
		driver.findElement(By.xpath("//button[@id='alertBtn']")).click();
		
		//used capture the text from the alert
		Alert myalert =  driver.switchTo().alert(); //used capture the text from the alert
		String text = myalert.getText();
//		Assert.assertEquals(text, "I am an alert box!");
//		myalert.accept();
		
		//or
		if(text.equals("I am an alert box!"))
		{
			myalert.accept();
		}else myalert.dismiss();
		
		
		//direct accept the alert
//		driver.findElement(By.xpath("//button[@id='alertBtn']")).click();
//		driver.switchTo().alert().accept(); // to click on alert you need to switch to alerts box - it will capture the current window and it will accept it
		
		
		//Confirmation alert (click on OK or cancel)
		/*driver.findElement(By.xpath("//button[@id='confirmBtn']")).click();
		Thread.sleep(5000);
		Alert alertMy = driver.switchTo().alert(); //accept the alert
		alertMy.accept(); //accept the alert
		alertMy.dismiss(); //cancel the alert
		*/
		
		
		//Prompt alert
		driver.findElement(By.xpath("//button[@id='promptBtn']")).click();
		Alert myPrompt = driver.switchTo().alert();
		myPrompt.sendKeys("Welcome to Alert");
		myPrompt.accept();
		
		
		//wihtout using switch we can use explisit wait 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		Alert mwait = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(mwait.getText());
		mwait.accept();
		
		
	}

}

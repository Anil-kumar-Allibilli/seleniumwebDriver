package day37JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorCode {

	//JavascriptExecutor is an interface
	// when we perform click() action or try to interact with webelements internally JavaScript statements and this statements communicate with webelements, if sometimes when click method is not able to execute javaScript then it will throw "Element intercepted exception", so we use directly JavaScript instead of using click
	public static void main(String[] args) 
	
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/#");
		driver.manage().window().maximize();
		
		//normal way is .sendkeys("Anil kumar")
		WebElement inputbox = driver.findElement(By.xpath("//input[@id='name']"));
		
		//using JavaScriptExecutors
		// for ChromeDriver driver = new ChromeDriver(); we can write JavascriptExecutor js = driver; becasue we are string chromreDriver(child) into JavascriptExecutor(parent), where WebDriver and JavascriptExecutor has no relation so we have to user casting "JavascriptExecutor js = (JavascriptExecutor) driver;"
		
		//alternate of sendkeys method
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','Anil kumar')",inputbox); // this will send the value = Anil kumar in to the inputbox field 
		
		//click on element using JS
		WebElement radio = driver.findElement(By.id("male"));
		js.executeScript("arguments[0].click()", radio);
	
	
	}

}

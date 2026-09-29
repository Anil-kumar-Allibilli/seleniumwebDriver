package day39;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomElements {

	
	//xpath cant hangle shadow DOMs, we can only use cssSelector, we need to use selector hub to get the cssSelector
	//else we can write out code, first we need to fins th shadow host and save the variable and using the variable get shadow root and using it get the shadow elements
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/#");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		//This Element is inside single shadow DOM.
		//String cssSelectorForHost1 = "#shadow_host";
		//Thread.sleep(1000);
		SearchContext shadow = driver.findElement(By.cssSelector("#shadow_host")).getShadowRoot();
		Thread.sleep(1000);
		shadow.findElement(By.cssSelector("input[type='text']")).sendKeys("Welcome to Shadow DOM");
		
		
		//This Element is inside single shadow DOM.
		String cssSelectorForHost1 = "#shadow_host";
		Thread.sleep(1000);
		SearchContext shadows = driver.findElement(By.cssSelector(cssSelectorForHost1)).getShadowRoot();
		Thread.sleep(1000);
		String blog = shadows.findElement(By.cssSelector("a[href='https://www.pavantestingtools.com/']")).getText();
		System.out.println("Text of BLOG: " +blog);
	}

}

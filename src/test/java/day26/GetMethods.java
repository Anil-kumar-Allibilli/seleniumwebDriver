package day26;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetMethods {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		//get url - Opens the webpage which was given
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		//getTitle - return the title of the webpage which was opened
		String title = driver.getTitle();
		System.out.println(title);
		
		//getCurrentURL
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		//getPrageSource - returns the source code of the page
		//String sourceCode = driver.getPageSource();
		//System.out.println(sourceCode);
		//getWindowHand
		String windowHandler = driver.getWindowHandle();
		System.out.println("window ID:" +windowHandler);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement vf = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("OrangeHRM, Inc")));
		vf.click();
		//driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		//getWindowHandles
		Set<String> gf = driver.getWindowHandles();
		System.out.println(gf);
		//approach 1 convert set to list
		List<String> windowlist = new ArrayList<String>(gf);//converts set into list because set does not have "get" method to get individual URLs in list, set dont have indexing
		String parentRILID =windowlist.get(0); 
		String childRILID = windowlist.get(1);
		//switch window
		driver.switchTo().window(childRILID); // window switched from parent to child
		System.out.println(driver.getTitle());
		for(String windowhanr:gf)
		{
			String browserTitle = driver.switchTo().window(windowhanr).getTitle();//getTitle will get the title of the brower which was opened
			System.out.println(browserTitle);
			if(browserTitle.equals("OrangeHRM"))
			{
				System.out.println(driver.getCurrentUrl());
				//driver.close(); /closed the currect opened Ul
			}
			System.out.println(windowhanr);
			
		}
		
	}

}

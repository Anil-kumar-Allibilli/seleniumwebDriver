package day26;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClosingSpecificBrowserWindow {

	public static void main(String[] args) 
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		//get url - Opens the webpage which was given
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		//getTitle - return the title of the webpage which was opened
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		Set<String> gf = driver.getWindowHandles();
		for(String winddow : gf) 
		{
			String title = driver.switchTo().window(winddow).getTitle();
			System.out.println(title);
			if(title.equals("OrangeHRM"))
			{
				driver.close();
			}
			
		}
	}

}

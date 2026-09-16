package day36KeyBoardActions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabsAndWindows {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/#");
		driver.manage().window().maximize();
		
		//WindowType.TAB - opens new tab
		//driver.switchTo().newWindow(WindowType.TAB); //it will switch and open new window
		
		//WindowType.WINDOW - opens new window
		driver.switchTo().newWindow(WindowType.WINDOW); //it will open new window 
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

}

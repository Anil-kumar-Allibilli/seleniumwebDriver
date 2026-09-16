package day1Automation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1) Launch Chrome browser
2) Open URL
3) Validate Title should be "Your Store"
4) close the browser
*/ 
public class FirstTestCase {

	public static void main(String[] args) 
	{
		//1) Launch Chrome through Automation
		//ChromeDriver driver = new ChromeDriver(); // in automation when we create ChromeDriver class, then constructor(inbuild constructor) is automatically called and this constructor will open the browser
		WebDriver driver = new ChromeDriver();//storing clild object in parent variable
		
		// 2) Open URL
		driver.get("https://www.opencart.com/");
		
		//3) Validate Title should be "OpenCart - Open Source Shopping Cart Solution"
		String actual_title = driver.getTitle();
		if(actual_title.equals("OpenCart - Open Source Shopping Cart Solution"))
		{
			System.out.println("Test case pass");
		}
		else
		{
			System.out.println("Test case fail");
		}
		
		//close the browser
		driver.close();
	}

}

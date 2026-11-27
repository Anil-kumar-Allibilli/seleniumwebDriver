package day45Parameterization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class XmlParemTest 
{
	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser"}) // we are getting browser from xml file <prameters tag, and br form tag value
	void setUp(String br) throws InterruptedException 
	{	
		switch(br)
		{
			case "chrome":	driver = new ChromeDriver(); break;
			case "edge":	driver = new EdgeDriver(); break;
			case "firefox":	driver = new FirefoxDriver(); break;
			default: System.out.println("Browser not supported"); return; // here return will exit from entire method so that rest of the code is not executed
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(10000);
	}
	
	@Test(priority=1)
	void testLogo()
	{
		boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(status, true);
	}
	
	@Test(priority=2)
	void testTittle()
	{
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	@Test(priority=3)
	void testURL()
	{
		Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login" );
	}
	
	@AfterClass
	void testClosure()
	{
		driver.close();
	}
	
}

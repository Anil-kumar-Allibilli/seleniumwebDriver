package day45Parameterization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders 
{
	WebDriver driver;
	@BeforeClass    //it executed only one time per class
	void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(dataProvider="dp")
	void testLogin(String email,String psw)
	{
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(psw);
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Warning: No match for E-Mail Address and/or Password.')]")).isDisplayed();
		String msg = driver.findElement(By.xpath("//div[contains(text(),'Warning: No match for E-Mail Address and/or Password.')]")).getText();
		if(msg.equals("Warning: No match for E-Mail Address and/or Password."))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
	}
	
	@AfterClass
	void testDown()
	{
		System.out.println("we can logg out");
	}
	
	@DataProvider(name="dp")   // Object[][] can hold any type of data so better to user objects
	Object[][] loginData()
	{
		Object idPassword[][] =
				{
					{"1admin1","admin0123"},
					{"2admin2","admin123"},
					{"3admin3","admin23"},
					{"Akchinna@test.ci","Akchinna"},
					{"5admin5","admin"}
				};
		return idPassword;
	}
}

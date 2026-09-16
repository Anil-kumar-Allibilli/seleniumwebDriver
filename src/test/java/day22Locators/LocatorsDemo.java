package day22Locators;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		//name attribute
		//driver.findElement(By.name("q")).sendKeys("poco 5g mobile");//findElement will find the element, and sendKeys will input the given parameter as textbox input
		
		//cick element
		//driver.findElement(By.name("q")).click();
		
		//Id
		//boolean logoDisplayed =  driver.findElement(By.id("logo")).isDisplayed(); //isDisplayed verifies element is visible in browser and returns true
		//System.out.println(logoDisplayed);
		
		
		//Linktext and partialLinkText, it works only for the anchor tags which has href, ex: <a ...>Noise Smartwatches</a>
		//l.findElement(By.linkText("Noise Smartwatches")).click(); 
		//l.findElement(By.partialLinkText("Noise")).click(); 
		
		//Tag and class name, user to get a group of elements
		//class anme
		List<WebElement> headerLink = driver.findElements(By.className("_1XjE3T"));// it returns list of web Elements, so we need list<WebElement> to store the results
		System.out.println("Total number of Top Offers: "+headerLink.size()); //get count of the class
		//Tag name
		List<WebElement> spanTag = driver.findElements(By.tagName("span"));
		System.out.println("Total number of span tags: "+spanTag.size());

		driver.close();
	}
}
  
package day23CssLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssLocators {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		
		//Tag ID -> tag#id
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-Shirts");//input#small-searchterms or only "#small-searchterms"
		
		//Tag class -> tag.classname
		//driver.findElement(By.cssSelector(".search-box-text")).sendKeys("T-Shirts");// or input.search-box-text
		
		//tag attribute -> tag[attribute = "value"]
		//driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("T-shorts");
		
		//tag class attribute 
		driver.findElement(By.cssSelector(".search-box-text[name='q']")).sendKeys("T-shorts");
	}

}

package day33DynamicPagination;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPaginationTable {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		//list of pages
		List<WebElement> no_of_pages = driver.findElements(By.xpath("//ul[@class=\"pagination\"]//a[@href=\"#\"]"));
		int countOfPages = no_of_pages.size();
		for(int p=1;p<=countOfPages;p++){
			for(WebElement page : no_of_pages) 
			{
			    System.out.println(page);  // prints "1", "2", "3", etc.
			    List<WebElement> bookNames = driver.findElements(By.xpath("//table[@id=\"productTable\"]//tbody//tr//td[2]"));
			    for(WebElement data:bookNames)
			    {
			    	System.out.println(data.getText());
			    }
			}
		}
		//string findign 
//		String s = driver.findElement(By.xpath("//ul[@class=\\\"pagination\\\"]//a[@href=\\\"#\\")).getText();
//		int pageNumber = Integer.parseInt(s.substring(s.indexOf("P")),s.indexOf("e"));
	}

}

package day39;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 1) Link href="error-page.asp?e=400"
 2) href="error-page.asp?e=400" ------> Server -------> status code
 3) status code>=400 broken link
 status code < 400 not a broken link
  */

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> links =   driver.findElements(By.tagName("a"));
		int countBrokenLink =0;
		for(WebElement link: links)
		{
			String hrefvalue =  link.getAttribute("href");
			if(hrefvalue == null || hrefvalue.isEmpty())
			{
				System.out.println("href value has null or empty, so not possable to access");
				continue;
			}
			
			//hit url to server
			try
			{
				URL linkurl = new URL(hrefvalue); //converted http value from string to URL format
				HttpURLConnection con = (HttpURLConnection) linkurl.openConnection(); //open connection to server
				con.connect(); //connect to server and send request to server
				int responcecode = con.getResponseCode();
				if(responcecode >= 400)
				{
					System.out.println(responcecode+ " is an Broker links");
					countBrokenLink++;
				}
				else if(responcecode <400)
				{
					System.out.println(responcecode+ " is not a Broker links");
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception for URL: " + hrefvalue + " → " + e.getMessage());
			}
			
		}
		System.out.println("number of broken links " +countBrokenLink);

	}

}

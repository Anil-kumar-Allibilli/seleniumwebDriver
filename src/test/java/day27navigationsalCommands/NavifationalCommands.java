package day27navigationsalCommands;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavifationalCommands {

	public static void main(String[] args) throws MalformedURLException 
	{
		WebDriver driver = new ChromeDriver();
		//driver.get("https://demo.nopcommerce.com/"); // accepts URL only in string format
		driver.navigate().to("https://demo.nopcommerce.com/");// same like get(URL), but here we can directly send URL or URL as an object
		URL objURL= new URL("https://demo.nopcommerce.com/");//URL is a class
		driver.navigate().to(objURL);
		driver.navigate().to("https://www.instagram.com/accounts/login/?hl=en");
		driver.navigate().to("https://www.facebook.com/");
		driver.navigate().back();//this will take browser back to insta from facebook
		System.out.println(driver.getCurrentUrl());
		driver.navigate().forward();//this will take browser forward and open facebook
		System.out.println(driver.getCurrentUrl());
		driver.navigate().refresh();//this will refresh the browser
		System.out.println(driver.getCurrentUrl());
	}

}

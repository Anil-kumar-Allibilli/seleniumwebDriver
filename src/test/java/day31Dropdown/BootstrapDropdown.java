package day31Dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropdown 
{

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://mdbootstrap.com/docs/standard/extended/multiselect/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.manage().window().maximize();
		
		//random window popups - closer the window if the window is available
		if(driver.findElement(By.xpath("//button[normalize-space(text())=\"ACCEPT COOKIES\"]")).isDisplayed())
		{
			driver.findElement(By.xpath("//button[normalize-space(text())=\"ACCEPT COOKIES\"]")).click();
		}
	
		driver.findElement(By.xpath("//input[@class=\"form-control select-input active\"]")).click();
		
		//select one check box
		driver.findElement(By.xpath("//span[normalize-space()='Two']")).click();
		List<WebElement> options = driver.findElements(
			    By.xpath("(//span[@class='select-option-text'])[position()>1]")
			);

			System.out.println("Number of options: " + options.size());

			for(WebElement opt : options) {
			    System.out.println(opt.getText());  // prints "Two", "Three", "Four", etc.
			}

	}

}

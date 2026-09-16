package day31Dropdown;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownHandling {

	public static void main(String[] args) 
	{
		//ther eare 3 types in dropdown selection 
		//select by visible text
		//select by value
		//select by index
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.manage().window().maximize();
		WebElement countryDropdown = driver.findElement(By.xpath("//select[@id='country']"));
		Select selectdropdown = new Select(countryDropdown);
		selectdropdown.selectByVisibleText("France"); //select with text in side in dropdown
		selectdropdown.selectByValue("uk"); //select byt values tag(attribute) in dropdown 
		selectdropdown.selectByIndex(5); //selects by index
		
		//capture all the option form the dropdown, getOption returns all the option from the dropdown
		List<WebElement> options= selectdropdown.getOptions();
		System.out.println("number of options in a dropdown " +options.size());
		
		//print the options
		for(WebElement  Dpoption:options)
		{
			System.out.println(Dpoption.getText());
		}
		//or
		for(int i = 0; i < options.size(); i++) {
		    System.out.println(options.get(i).getText());
		}

	}

}

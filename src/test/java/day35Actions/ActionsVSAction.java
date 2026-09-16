package day35Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsVSAction {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo/input.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		WebElement rcButton = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		
		//Actions = is a class user to perform action like mouseover, rightclick etc
		//Action = is an interface used to store created action;
		Actions action = new Actions(driver);
		Action myaction = action.contextClick(rcButton).build(); // create/building an action, perform later
		myaction.perform(); // performing/completion the action

	}

}

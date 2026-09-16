package day35Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class DragAndDropAction {

	public static void main(String[] args) 
	{
		
		WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/#");
        driver.manage().window().maximize();

        WebElement studentT = driver.findElement(By.xpath("//p[normalize-space()='Drag me to my target']"));
        highlightElement(driver, studentT);
        WebElement teamD = driver.findElement(By.xpath("//div[@id='droppable']"));
        highlightElement(driver, teamD);

        // Perform drag and drop
        Actions actions = new Actions(driver);
        actions.clickAndHold(studentT)
        .moveToElement(teamD)
        .release()
        .build()
        .perform();
        //actions.dragAndDrop(studentT, teamD).perform();
	}
	public static void highlightElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid green'", element);
	}

}

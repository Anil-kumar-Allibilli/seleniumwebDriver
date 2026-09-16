package day26;
import java.time.Duration;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.util.NoSuchElementException;

public class Fluentwait {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)//declaration of fluentwait
        	       .withTimeout(Duration.ofSeconds(30L))//wait for until 30 seconds
        	       .pollingEvery(Duration.ofSeconds(5L)) //How frequently Selenium should check condition.
        	       .ignoring(NoSuchElementException.class);

        	   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {// usage of fluent wait
        	     public WebElement apply(WebDriver driver) {
        	       return driver.findElement(By.id("foo"));
        	     }
        	   });
        	   foo.sendKeys("test");
        	  
    }
}

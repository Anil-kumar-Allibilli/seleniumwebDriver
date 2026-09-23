package day38ScreenShots;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshits {

	public static void main(String[] args) 
	{
		
		//full page screenshot
		//Specific area from the page
		//Web element
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/#");
		driver.manage().window().maximize();
		
		
		//full page screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File filelocation = new File("C:\\Workspaces\\SeleniumWebDriver\\seleniumwebDriver\\ScreenShotsFolder\\fullpage.png"); //used to save the takens screen shits in required loaciton 
		
		//if the file is screenshots file location changed then we can give dynamic file location
		//File dynamiclocation = new File(System.getProperty("user.dir")+"\\ScreenShotsFolder\\fullpage.png");
		
		//now copy the sorce file to targetFile
		source.renameTo(filelocation);
		
		
		//capture Screenshot from Specific area from the page
		WebElement featuredProuct = driver.findElement(By.xpath("//div[@class=\"blog-posts hfeed\"]"));
		File psource = featuredProuct.getScreenshotAs(OutputType.FILE);
		File ptargetLocation = new File(System.getProperty("user.dir")+ "\\ScreenShotsFolder\\specificArea.png");
		psource.renameTo(ptargetLocation); // or FileUtils.copyFile(psource, ptargetLocation);
		
		
		//screenshot of specific element //h1[@class="title"]
		WebElement speciElement = driver.findElement(By.xpath("//h1[@class=\"title\"]"));
		File Ssource = speciElement.getScreenshotAs(OutputType.FILE);
		File stargetLocation = new File(System.getProperty("user.dir")+ "\\ScreenShotsFolder\\specificElement.png");
		Ssource.renameTo(stargetLocation); // or FileUtils.copyFile(psource, ptargetLocation);
	}

}

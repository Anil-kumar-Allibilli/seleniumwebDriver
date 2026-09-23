package day38ScreenShots;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RunInIncognitoMode {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("--incognito"); // user to run test in incognito mode
		
		
		WebDriver driver = new ChromeDriver(options); 
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("C:\\Users\\User\\Desktop\\Selenium\\Selenium notes\\Selenium Classes and method formats.docx");
		String text = driver.findElement(By.xpath("//ul[@id=\"fileList\"]/li")).getText();
		if(text.equals("Selenium Classes and method formats.docx"))
		{
			System.out.println("file is uploaded successfully");
		}
		else
		{
			System.out.println("file not uploaded");
		}

		
		//multiple files upload 
		String file1 = "C:\\Users\\User\\Desktop\\Selenium\\Selenium notes\\Selenium Classes and method formats.docx";
		String file2 = "C:\\Users\\User\\Desktop\\Selenium\\Selenium notes\\Selenium project Framework.docx";
		
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+ "\n" +file2); // here \n is for new line
	}
}

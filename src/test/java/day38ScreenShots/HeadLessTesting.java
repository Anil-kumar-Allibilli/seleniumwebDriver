package day38ScreenShots;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLessTesting {

	
	// head less testing means executing the test from Backend, we cant see UI changes at the end we will see only results of test, we can change setting of the drowsers using this headless 
	
	// headless mode will be used in DevOps environment
	//Advantages: 1) we can do multiple tasks in the bakend since execution is happening in the backend
	            //2) faster execution 
				//3) when we want to execute test multiple times and we dont need only UI interaction at that point we can user Headless mode
	
	//disadvantages: 1) user can not see the action happening on the page, so can not undersatand the flow and functionality of the page
                   //2) faster execution 
	public static void main(String[] args) 
	{
		
			ChromeOptions options = new ChromeOptions(); // to run in HeadLess mode we will use ChromeOptins/EdgeOptions/FireFox Options
			options.addArguments("--headless=new"); // it is setting for headless mode of execution,  this will make the test headless
			
			
			WebDriver driver = new ChromeDriver(options); // we need to pass chromerOption object here so that chrome work under headless
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

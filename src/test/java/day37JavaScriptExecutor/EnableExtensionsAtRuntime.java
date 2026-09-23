package day37JavaScriptExecutor;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EnableExtensionsAtRuntime {

	
	// 
	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions(); 
		
		//1) download CRX downaded extension
		//2) download any extension, in extention Right click and click on download extention
		//3) save the file and give the path of that file 
		File crx = new File("C:\\Users\\User\\Desktop\\Selenium\\Selenium notes\\CRX file of Selector hub.crx");
		options.addExtensions(crx); // when we want to user any expectios in the autoamation browser can can user it, 
		
		
		
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

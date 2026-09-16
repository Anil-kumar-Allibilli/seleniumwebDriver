package day29AlertsHandling;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



// we can not pass user name and password, so we will give the user name and password form URL only "Original URL: https://the-internet.herokuapp.com/basic_auth" we have to chage like 
//"https:username:password@//the-internet.herokuapp.com/basic_auth"
//"https://admin:admin@the-internet.herokuapp.com/basic_auth"
public class AuthenticationAlertHandling {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		//syntax: //"https:username:password@//the-internet.herokuapp.com/basic_auth"
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

	}

}

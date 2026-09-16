package ProjectCureMulti;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Executor {
    public static void main(String[] args) {
        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("https://katalon-demo-cura.herokuapp.com/");

            // Sample input
            String MakeAppointment = "//a[@id='btn-make-appointment']";
            String action = "click";
            String inputText = "John Doe";
            //String demoUserName = "//input[@aria-describedby=\"demo_username_label\"]";

            // Call performer
            ActionPerformer.clickElement(driver, MakeAppointment, action, inputText);
            String demoUserName = "//input[@placeholder=\"Username\" and @value]";
            ActionPerformer.saveData(driver, demoUserName, action);
            MakeAppointment = "//input[@name=\"username\"]";
            action = "inputText";
            ActionPerformer.clickElement(driver, MakeAppointment, action, inputText);
            demoUserName = "//input[@placeholder=\"Password\" and @value and @type=\"text\"]";
            ActionPerformer.saveData(driver, demoUserName, action);
            MakeAppointment = "//input[@type='password' and @value]";
            action = "inputText";
            ActionPerformer.clickElement(driver, MakeAppointment, action, inputText);
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        } finally {
            if (driver != null) {
               // driver.quit();
            }
        }
    }
}


package ProjectCure;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class CuraAutomationTest {

    public static void main(String[] args) {
        WebDriver driver = null;

        try {
            // Setup
            //System.setProperty("webdriver.chrome.driver", "chromedriver"); // optional if using WebDriverManager
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("https://katalon-demo-cura.herokuapp.com/");

            // Click anchor tag (Make Appointment)
            WebElement makeAppointmentBtn = driver.findElement(By.id("btn-make-appointment"));
            highlightElement(driver, makeAppointmentBtn);
            if (makeAppointmentBtn.isDisplayed()) {
                makeAppointmentBtn.click();
                System.out.println("Clicked on 'Make Appointment'");
            }

            // Input username
            WebElement username = driver.findElement(By.id("txt-username"));
            highlightElement(driver, username);
            username.sendKeys("John Doe");

            // Input password
            WebElement password = driver.findElement(By.id("txt-password"));
            highlightElement(driver, password);
            password.sendKeys("ThisIsNotAPassword");

            // Press Enter
            highlightElement(driver, password);
            password.sendKeys(Keys.ENTER);
            System.out.println("Entered credentials and hit ENTER");

            // Dropdown: facility
            WebElement facilityDropdown = driver.findElement(By.id("combo_facility"));
            scrollIntoView(driver, facilityDropdown);
            highlightElement(driver, facilityDropdown);

            Select facilitySelect = new Select(facilityDropdown);
            String selectedFacility = facilitySelect.getFirstSelectedOption().getText();
            System.out.println("Facility Selected: " + selectedFacility);

            // Checkbox
            WebElement readmissionCheckbox = driver.findElement(By.id("chk_hospotal_readmission"));
            highlightElement(driver, readmissionCheckbox);
            readmissionCheckbox.click();
            String checkboxText = readmissionCheckbox.getAttribute("value");
            String partialText = checkboxText.length() > 5 ? checkboxText.substring(0, 5) : checkboxText;
            System.out.println("Saved Substring: " + partialText);

            // Comment box
            WebElement commentBox = driver.findElement(By.id("txt_comment"));
            scrollIntoView(driver, commentBox);
            highlightElement(driver, commentBox);
            commentBox.sendKeys("Test appointment comment");

            // Book Appointment
            WebElement bookBtn = driver.findElement(By.id("btn-book-appointment"));
            highlightElement(driver, bookBtn);
            bookBtn.click();
            System.out.println("Clicked on Book Appointment");

            // Confirmation
            WebElement confirmation = driver.findElement(By.tagName("h2"));
            highlightElement(driver, confirmation);
            if (confirmation.getText().contains("Appointment Confirmation")) {
                System.out.println("Appointment booked successfully ✅");
            } else {
                System.out.println("Failed to book appointment ❌");
            }

        } catch (NoSuchElementException e) {
            System.out.println("Element not found! ❗ Details: " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for element ❗ Details: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error ❗ Details: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    // Highlight Element
    private static void highlightElement(WebDriver driver, WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String originalStyle = element.getAttribute("style");
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
                    element, "border: 5px solid green; border-style: dashed;");
            Thread.sleep(500);
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
                    element, originalStyle);
        } catch (Exception e) {
            System.out.println("Highlight failed: " + e.getMessage());
        }
    }

    // Scroll to view
    private static void scrollIntoView(WebDriver driver, WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Scroll interrupted: " + e.getMessage());
        }
    }
}

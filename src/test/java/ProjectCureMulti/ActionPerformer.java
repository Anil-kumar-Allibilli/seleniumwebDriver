package ProjectCureMulti;

import org.openqa.selenium.*;

public class ActionPerformer 
{

    public static void clickElement(WebDriver driver, String MakeAppointment, String action, String inputText) 
    {
        try {
            WebElement element = driver.findElement(By.xpath(MakeAppointment));
            WebUtils.highlightElement(driver, element);
            WebUtils.scrollIntoView(driver, element);

            switch (action.toLowerCase()) 
            {
                case "click":
                    element.click();
                    System.out.println("Clicked on element: " + MakeAppointment);
                    break;

                case "isvisible":
                    System.out.println("Element is visible: " + element.isDisplayed());
                    break;

                case "inputtext":
                    element.clear();
                    element.sendKeys(inputText);
                    System.out.println("Input text: " + inputText);
                    break;

                case "enterkey":
                    element.sendKeys(Keys.ENTER);
                    System.out.println("↩️ Enter key pressed");
                    break;

                case "scrollto":
                    System.out.println("🖱️ Scrolled to element: " + MakeAppointment);
                    break;

                default:
                    System.out.println("❌ Unknown action: " + action);
            }

        } 
        catch (NoSuchElementException e) 
        {
            System.out.println("❗ Element not found for XPath: " + MakeAppointment);
        } catch (Exception e) 
        {
            System.out.println("❗ Error performing action '" + action + "' on " + MakeAppointment + ": " + e.getMessage());
        }
    }
    public static String saveData(WebDriver driver, String demoUserName, String action) {
        String savedValue = "";
        try {
            WebElement element = driver.findElement(By.xpath(demoUserName));
            WebUtils.highlightElement(driver, element);
            WebUtils.scrollIntoView(driver, element);

            switch (action.toLowerCase()) {
                case "savedata":
                    savedValue = element.getText();
                    System.out.println("📌 Saved data: " + savedValue);
                    break;
                case "isvisible":
                    System.out.println("Element is visible: " + element.isDisplayed());
                    break;
                default:
                    System.out.println("❌ Unknown action: " + action);
            }
        } catch (NoSuchElementException e) {
            System.out.println("❗ Element not found for XPath: " + demoUserName);
        }
        return savedValue;
    }
    
}

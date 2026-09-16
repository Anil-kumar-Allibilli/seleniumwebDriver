package ProjectCureMulti;
import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;

public class WebUtils {

    public static void highlightElement(WebDriver driver, WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String originalStyle = element.getAttribute("style");
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
                    element, "border: 3px solid green; box-shadow: 0 0 10px green;");
            Thread.sleep(400);
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
                    element, originalStyle);
        } catch (Exception e) {
            System.out.println("⚠️ Highlighting failed: " + e.getMessage());
        }
    }

    public static void scrollIntoView(WebDriver driver, WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(300);
        } catch (Exception e) {
            System.out.println("⚠️ Scroll failed: " + e.getMessage());
        }
    }
}


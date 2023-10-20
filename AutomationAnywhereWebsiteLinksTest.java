import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class AutomationAnywhereWebsiteLinksTest {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Documents\\chromedriver-win64\\chromedriver.exe");

        // Initialize ChromeDriver with ChromeOptions for handling cookies and maximizing the browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Maximize the browser window
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Define the link texts you want to verify
        String[] linkTexts = {
            "Products",
            "Solutions",
            "Resources",
            "Beyond RPA",
            "Company"
        };

        // Define the corresponding expected URLs
        String[] expectedUrls = {
            "https://www.automationanywhere.com/products",
            "https://www.automationanywhere.com/solutions",
            "https://www.automationanywhere.com/resources",
            "https://www.automationanywhere.com/rpa/robotic-process-automation",
            "https://www.automationanywhere.com/company/about-us"
        };

        // Navigate to the website
        driver.get("https://www.automationanywhere.com");

        // Handle the cookie banner by accepting cookies
        try {
            By acceptCookiesButton = By.xpath("//button[@id='onetrust-accept-btn-handler']");
            WebElement cookiesAcceptButton = wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
            if (cookiesAcceptButton != null) {
                cookiesAcceptButton.click();
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
            // Cookie banner not found, continue
        }

        for (int i = 0; i < linkTexts.length; i++) {
            String linkText = linkTexts[i];
            WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), '" + linkText + "')]")));

            if (link != null) {
                System.out.println(linkText + " link is present.");
                // Click the link
                link.click();
                // Verify if it navigated to the proper page
                if (driver.getCurrentUrl().equals(expectedUrls[i])) {
                    System.out.println(linkText + " link navigated to the proper page.");
                } else {
                    System.out.println(linkText + " link did not navigate to the proper page.");
                }
                // Go back to the homepage for the next link verification
                driver.navigate().back();
            } else {
                System.out.println(linkText + " link is not present.");
            }
        }

        // Close the browser
        driver.quit();
    }
}


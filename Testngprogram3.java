package testing;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.TimeoutException;

import java.time.Duration; // Import the Duration class

public class Testngprogram3 {
    private WebDriver driver;

    @Test(priority = 1, enabled = true, timeOut = 60000) // Set the priority, enabled, and timeOut attributes
    public void checkLogoPresence() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Documents\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.automationanywhere.com/");
        WebElement logo = driver.findElement(By.xpath("//img[@alt='Automation Anywhere']"));
        assert logo.isDisplayed() : "Automation Anywhere logo is not present.";
        driver.quit();
    }

    @Test(priority = 2, enabled = true, timeOut = 60000) // Set the priority, enabled, and timeOut attributes
    public void checkRequestDemoButton() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Documents\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
        By requestDemoButtonLocator = By.xpath("//a[text()='Request Demo']");

        try {
            // Wait for the "Request Demo" button to be present
            WebElement requestDemoButton = wait.until(ExpectedConditions.presenceOfElementLocated(requestDemoButtonLocator));

            // Check if the button is displayed
            if (requestDemoButton.isDisplayed()) {
                System.out.println("Request Demo button is present and visible.");
            } else {
                System.out.println("Request Demo button is present but not visible.");
            }
        } catch (TimeoutException e) {
            System.out.println("Request Demo button is not present or took too long to appear.");
        } finally {
            driver.quit(); // Close the browser after the test
        }
    }
}


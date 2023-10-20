
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationAnywhereWebsiteTest {
    public static void main(String[] args) {
        
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Documents\\chromedriver-win64\\chromedriver.exe");


        WebDriver driver = new ChromeDriver();

        driver.get("https://www.automationanywhere.com/");

        WebElement logo = driver.findElement(By.xpath("//img[@alt='Automation Anywhere']"));
        if (logo.isDisplayed()) {
            System.out.println("Automation Anywhere logo is present.");
        } else {
            System.out.println("Automation Anywhere logo is not present.");
        }

        WebElement requestDemoButton = driver.findElement(By.xpath("//a[text()='Request Demo']"));
        if (requestDemoButton.isDisplayed()) {
            System.out.println("Request Demo button is present.");
            if (requestDemoButton.isEnabled()) {
                System.out.println("Request Demo button is clickable.");
                // You can perform further actions like clicking the button if needed
                // requestDemoButton.click();
            } else {
                System.out.println("Request Demo button is not clickable.");
            }
        } else {
            System.out.println("Request Demo button is not present.");
        }

        driver.quit();
    }
}



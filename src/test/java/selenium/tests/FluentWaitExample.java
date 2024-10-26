package selenium.tests;

// Import necessary packages

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class FluentWaitExample {
    public static void main(String[] args) {
        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

                // Define FluentWait
                Wait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(30))      // Maximum wait time
                        .pollingEvery(Duration.ofSeconds(2))      // Polling interval
                        .ignoring(NoSuchElementException.class);  // Ignoring specific exceptions

        // Define condition with Function
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("elementID"));
            }
        });


        // Close the driver
        driver.quit();
    }
}



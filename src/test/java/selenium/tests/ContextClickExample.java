package selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextClickExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");

        // Locate the element to right-click
        WebElement element = driver.findElement(By.id("right-click-element"));

        // Create an Actions object
        Actions actions = new Actions(driver);

        // Perform context click (right-click)
        actions.contextClick(element).perform();

        // Close the browser
        driver.quit();
    }
}


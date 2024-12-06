package selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com/drag-and-drop");

        // Locate the source and target elements
        WebElement sourceElement = driver.findElement(By.id("source"));
        WebElement targetElement = driver.findElement(By.id("target"));

        // Create an Actions object
        Actions actions = new Actions(driver);

        // Perform drag and drop action
        actions.dragAndDrop(sourceElement, targetElement).perform();

        // Close the browser
        driver.quit();
    }
}


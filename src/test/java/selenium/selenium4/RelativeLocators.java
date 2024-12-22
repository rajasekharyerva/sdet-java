package selenium.selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            // Open the test page
            driver.get("https://www.selenium.dev/documentation/en/");

            // Locate reference element
            WebElement referenceElement = driver.findElement(By.linkText("Selenium WebDriver"));

            // Using relative locators
            WebElement aboveElement = driver.findElement(with(By.tagName("input")).above(referenceElement));
            WebElement belowElement = driver.findElement(with(By.tagName("input")).below(referenceElement));
            WebElement leftElement = driver.findElement(with(By.tagName("input")).toLeftOf(referenceElement));
            WebElement rightElement = driver.findElement(with(By.tagName("input")).toRightOf(referenceElement));
            WebElement nearElement = driver.findElement(with(By.tagName("input")).near(referenceElement));

            // Print results
            System.out.println("Above: " + aboveElement.getText());
            System.out.println("Below: " + belowElement.getText());
            System.out.println("Left: " + leftElement.getText());
            System.out.println("Right: " + rightElement.getText());
            System.out.println("Near: " + nearElement.getText());

        } finally {
            // Close the browser
            driver.quit();
        }

    }
}

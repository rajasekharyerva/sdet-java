package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.List;

public class ProductDescriptionFinder {
    public static void main(String[] args) {
        // Set up the ChromeDriver (ensure chromedriver is in your PATH or provide the full path)
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Load the webpage that contains the XML structure
        String filePath = new File("/Users/rajasekharreddyyerva/IdeaProjects/sdet2-repo/src/test/java/selenium/sample.html").getAbsolutePath(); // Update with your actual path
        driver.get("file:///" + filePath);

        // Use XPath to locate all <product> elements where <description> contains 'sff'
        List<WebElement> products = driver.findElements(By.xpath("//product[contains(description, 'sff')]/name"));

        // Iterate through the matched products and print their names
        for (WebElement product : products) {
            System.out.println("Product Name with description containing 'sff': " + product.getText());
        }

        // Close the driver
        driver.quit();
    }
}


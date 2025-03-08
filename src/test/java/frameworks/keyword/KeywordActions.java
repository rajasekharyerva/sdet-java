package frameworks.keyword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeywordActions {
    WebDriver driver;

    // Open Browser (frameworks.keyword)
    public void openBrowser(String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();  // Launches Chrome
        }
        // Add support for other browsers like Firefox, Safari, etc.
    }

    // Navigate to a URL (frameworks.keyword)
    public void navigate(String url) {
        driver.get(url);  // Navigates to the URL
    }

    // Enter Text into a field (frameworks.keyword)
    public void enterText(String fieldName, String text) {
        driver.findElement(By.name(fieldName)).sendKeys(text);  // Finds the field by name and enters text
    }

    // Click a button (frameworks.keyword)
    public void click(String elementId) {
        driver.findElement(By.id(elementId)).click();  // Clicks the button with the given ID
    }

    // Verify Text on page (frameworks.keyword)
    public void verifyText(String elementId, String expectedText) {
        String actualText = driver.findElement(By.id(elementId)).getText();
        if (actualText.equals(expectedText)) {
            System.out.println("Verification Passed!");
        } else {
            System.out.println("Verification Failed!");
        }
    }

    // Close the browser (frameworks.keyword)
    public void closeBrowser() {
        driver.quit();  // Close the browser
    }
}

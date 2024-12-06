package selenium;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BrokenLinksCheckerRestAssured {
    public static void main(String[] args) {
        // Set up WebDriver (Chrome)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Open the website
        driver.get("https://yourwebsite.com");

        // Find all the anchor elements (links)
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // Check each link for its status
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url != null && !url.isEmpty()) {
                verifyLink(url);
            }
        }

        // Close the browser
        driver.quit();
    }

    public static void verifyLink(String url) {
        try {
            // Use Rest Assured to send a GET request and check the status // HttpURLConnection or HttpClient
            Response response = RestAssured.given().head(url); // HEAD request to check the status
            int statusCode = response.getStatusCode();

            // If the status code indicates a broken link (4xx or 5xx), print it
            if (statusCode >= 400) {
                System.out.println("Broken Link: " + url + " | Response Code: " + statusCode);
            } else {
                System.out.println("Valid Link: " + url + " | Response Code: " + statusCode);
            }
        } catch (Exception e) {
            System.out.println("Error with Link: " + url + " | Exception: " + e.getMessage());
        }
    }
}

package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinkChecker {

    public static void main(String[] args) {
        // Set up WebDriver (ensure you have ChromeDriver in your PATH)
        System.setProperty("webdriver.chrome.driver", "path_to_your_chromedriver");

        WebDriver driver = new ChromeDriver();

        // Navigate to the page you want to check
        driver.get("http://example.com");

        // Find all the links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links found: " + links.size());

        // Loop through each link and check its status code
        for (WebElement link : links) {
            String url = link.getAttribute("href");

            if (url == null || url.isEmpty()) {
                continue; // Skip empty or null URLs
            }

            checkBrokenLink(url);
        }

        // Close the browser
        driver.quit();
    }

    public static void checkBrokenLink(String url) {
        try {
            // Create a URL object from the link
            URL link = new URL(url);

            // Open a connection to the URL
            HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();

            // Set the request method to "GET"
            httpURLConnection.setRequestMethod("GET");

            // Set a timeout for the connection
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);

            // Get the HTTP response code
            int responseCode = httpURLConnection.getResponseCode();

            // If the response code is 404, it's a broken link
            if (responseCode == HttpURLConnection.HTTP_NOT_FOUND) {
                System.out.println(url + " - Broken Link (404)");
            }
        } catch (Exception e) {
            // Handle any exceptions (e.g., malformed URLs or network errors)
            System.out.println(url + " - Error: " + e.getMessage());
        }
    }
}


package selenium.tests;

import io.restassured.response.Response;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Map;

public class APICookiesIntegration {

    public static void main(String[] args) {
        // Step 1: Generate Cookies via API
        Response response = io.restassured.RestAssured
                .given()
                .baseUri("https://example.com")
                .contentType("application/json")
                .body("{ \"username\": \"user\", \"password\": \"pass\" }")
                .post("/api/login");

        // Extract cookies from API response
        Map<String, String> cookies = response.getCookies();
        System.out.println("API Cookies: " + cookies);

        // Step 2: Set Cookies in Selenium WebDriver
        System.setProperty("webdriver.chrome.driver", "path-to-chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");

        for (Map.Entry<String, String> cookieEntry : cookies.entrySet()) {
            Cookie seleniumCookie = new Cookie(cookieEntry.getKey(), cookieEntry.getValue());
            driver.manage().addCookie(seleniumCookie);
        }

        // Step 3: Navigate to Authenticated Page
        driver.navigate().refresh(); // Refresh to apply cookies
        driver.get("https://example.com/dashboard"); // Access an authenticated page

        // Continue with other test scenarios
        System.out.println("Page title: " + driver.getTitle());

        // Cleanup
        driver.quit();
    }
}


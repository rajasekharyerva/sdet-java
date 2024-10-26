package selenium.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            boolean hub = true;
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless"); // Run in headless mode
            options.addArguments("--no-sandbox"); // Bypass OS security model
            options.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems
            options.addArguments("--window-size=1920,1080"); // Set window size
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

            if(!hub){
                // Specify the hub URL
                String hubUrl = "http://localhost:4444/wd/hub";

                // Define ChromeOptions to set Chrome-specific capabilities
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--headless"); // Example: Running in headless mode

                // Set up DesiredCapabilities and merge with ChromeOptions
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                // Initialize the RemoteWebDriver
                try {
                    driver = new RemoteWebDriver(new URL(hubUrl), capabilities);
                } catch (MalformedURLException e) {
                    System.out.println("MalformedURLException");
                    //throw new RuntimeException(e);
                }
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}


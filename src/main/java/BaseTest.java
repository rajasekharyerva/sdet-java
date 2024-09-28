import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;

import java.io.File;

public class BaseTest {
    WebDriver webDriver;

    public void setURL() {
        // Create an instance of ConfigReader
        ConfigReader configReader = new ConfigReader();

        // Access values from the properties file
        String url = configReader.getProperty("local_url");

        File file  = new File(System.getProperty("user.dir") + url);
        String filePath = "file:///"+file.getAbsolutePath();
        webDriver.get(filePath);
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run in headless mode
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems
        options.addArguments("--window-size=1920,1080"); // Set window size
        System.out.println("WebDriver Initialization");
        webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
        setURL();
        System.out.println("setUp");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        System.out.println("tearDown");
        webDriver.quit();
    }


}

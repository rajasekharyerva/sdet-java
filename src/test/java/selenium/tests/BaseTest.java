package selenium.tests;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import selenium.utilities.ConfigReader;
import selenium.utilities.DriverManager;
import selenium.utilities.ScreenshotListener;


@Listeners(ScreenshotListener.class)
public class BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp(ITestResult result){
        System.setProperty("allure.results.directory", "Aallure-results");
        System.setProperty("browser", "Chrome");
        //System.setProperty("os", "Windows 10");

        logger.info("Starting test: {}", result.getMethod().getDescription());
        // Get WebDriver instance from DriverManager
        driver = DriverManager.getDriver();
        // Create an instance of ConfigReader
        ConfigReader configReader = new ConfigReader();
        driver.get(configReader.getProperty("web_url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result){
        logger.info("Finished test: {}", result.getMethod().getDescription());
        DriverManager.quitDriver();
    }


}

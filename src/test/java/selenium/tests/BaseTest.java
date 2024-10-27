package selenium.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import selenium.utilities.ConfigReader;
import selenium.utilities.DriverManager;
import selenium.utilities.ScreenshotListener;
import selenium.utilities.SummaryReportGenerator;


@Listeners({ScreenshotListener.class, AllureTestNg.class})
public class BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    WebDriver driver;
    public static ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public void setUpReport() {
        // Create an instance of ExtentSparkReporter
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        // Create an ExtentReports instance and attach the HTML reporter
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(ITestResult result){
        //test = extent.createTest(result.getMethod().getDescription());
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

    @AfterClass
    public void tearDownClass() {
        //extent.flush();
    }

    @AfterSuite
    public void generateReport() {
        SummaryReportGenerator.generateSummaryReport();

    }

}

package selenium.tests.tdd;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class FormTests {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Specify the path to your WebDriver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    // DataProvider for tc1
    @DataProvider(name = "tc1Data")
    public Object[][] tc1Data() {
        return new Object[][]{
                {DataUtil.getTestData("src/test/resources/testData.xlsx", "tc1")[0]} // Load data for tc1
        };
    }

    // DataProvider for tc2
    @DataProvider(name = "tc2Data")
    public Object[][] tc2Data() {
        return new Object[][]{
                {DataUtil.getTestData("src/test/resources/testData.xlsx", "tc2")[0]} // Load data for tc2
        };
    }

    // DataProvider for tc3
    @DataProvider(name = "tc3Data")
    public Object[][] tc3Data() {
        return new Object[][]{
                {DataUtil.getTestData("src/test/resources/testData.xlsx", "tc3")[0]} // Load data for tc3
        };
    }

    @Test(dataProvider = "tc1Data")
    public void testCase1(Map<String, String> testData) {
        driver.get("https://example.com/form"); // Adjust with the actual URL

        // Fill in the username and password for tc1
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys(testData.get("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(testData.get("password"));

        // Submit the form
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Assertion for tc1
        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"), "URL did not redirect to dashboard");
    }

    @Test(dataProvider = "tc2Data")
    public void testCase2(Map<String, String> testData) {
        driver.get("https://example.com/form"); // Adjust with the actual URL

        // Fill in the last name and city for tc2
        WebElement lastNameField = driver.findElement(By.name("lastName"));
        lastNameField.sendKeys(testData.get("lastName"));
        WebElement cityField = driver.findElement(By.name("city"));
        cityField.sendKeys(testData.get("city"));

        // Submit the form
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Assertion for tc2
        Assert.assertTrue(driver.findElement(By.id("updateMessage")).isDisplayed(), "Update message not displayed");
    }

    @Test(dataProvider = "tc3Data")
    public void testCase3(Map<String, String> testData) {
        driver.get("https://example.com/form"); // Adjust with the actual URL

        // Fill in all fields for tc3
        WebElement firstNameField = driver.findElement(By.name("firstName"));
        firstNameField.sendKeys(testData.get("firstName"));
        WebElement lastNameField = driver.findElement(By.name("lastName"));
        lastNameField.sendKeys(testData.get("lastName"));
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys(testData.get("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(testData.get("password"));
        WebElement cityField = driver.findElement(By.name("city"));
        cityField.sendKeys(testData.get("city"));
        WebElement dobField = driver.findElement(By.name("dob"));
        dobField.sendKeys(testData.get("dob"));

        // Submit the form
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Assertion for tc3
        Assert.assertTrue(driver.findElement(By.id("successMessage")).isDisplayed(), "Success message not displayed");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

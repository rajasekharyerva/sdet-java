package selenium.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureTestNg.class})
public class SampleAllureTest {
    private WebDriver driver;

    @BeforeClass
    @Step("Setting up the WebDriver and navigating to the form page")
    public void setUp() {
       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://example.com/form"); // Change to your test URL
    }

    @Test(description = "Fill Form Test", groups = "smoke")
    @Feature("Form Filling")
    public void fillForm() {
        enterFirstName("John");
        enterLastName("Doe");
        // You can add more steps here
    }

    @Step("Entering first name: {name}")
    public void enterFirstName(String name) {
        /*WebElement firstNameField = driver.findElement(By.id("firstName"));
        firstNameField.sendKeys(name);*/
    }

    @Step("Entering last name: {name}")
    public void enterLastName(String name) {
        /*WebElement lastNameField = driver.findElement(By.id("lastName"));
        lastNameField.sendKeys(name);*/
    }

    @AfterClass
    @Step("Closing the WebDriver")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

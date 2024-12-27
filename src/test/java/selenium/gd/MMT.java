package selenium.gd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class MMT {
    WebDriver webDriver;

    @BeforeMethod
    public void openBrowser() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.makemytrip.com/");
    }

    @Test
    public void mmt() {

        WebDriverWait explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        WebElement closeModal = webDriver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        explicitWait.until(ExpectedConditions.visibilityOf(closeModal));
        closeModal.click();
        WebElement from = webDriver.findElement(By.xpath("//input[@id='fromCity']"));
        from.click();
        WebElement fromInput = webDriver.findElement(By.xpath("//input[@placeholder='From']"));
        fromInput.click();
        String searchInput = "benga";
        fromInput.sendKeys(searchInput);
        List<WebElement> searchOptions = webDriver.findElements(By.xpath("//ul[@role='listbox']/li//div/p[contains(@class,'blackText')]"));

        //explicitWait.until(ExpectedConditions.invisibilityOf(searchOptions.get(0)));
        for (WebElement we : searchOptions) {
            if (we.getText().toLowerCase().contains(searchInput)) {
                we.click();
                break;
            }
        }
        boolean isStale = explicitWait.until(ExpectedConditions.stalenessOf(fromInput));
        if (isStale)
            fromInput = webDriver.findElement(By.xpath("//input[@id='fromCity']"));
        Assert.assertEquals(fromInput.getAttribute("value"), "Bengalurum", "From Expected value does not match the actual value");
    }

    @AfterMethod
    public void closeBrowser() {
        webDriver.quit();
    }
}

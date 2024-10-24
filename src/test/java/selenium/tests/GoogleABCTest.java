package selenium.tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class GoogleABCTest {
    WebDriver webDriver;
    @Test
    public void captureClickFirst() throws InterruptedException, IOException {
        webDriver.get("https://www.google.com/");
        WebElement search = webDriver.findElement(By.xpath("//textarea[@name='q']"));
        search.click();
        search.sendKeys("ABC");
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']/li//span")));
        List<WebElement> autoList = webDriver.findElements(By.xpath("//ul[@role='listbox']/li"));
        System.out.println(autoList.size());
        String span1Text = null;
        for(WebElement listElement: autoList) {
            List<WebElement> spanElements = listElement.findElements(By.tagName("span"));
            System.out.println(spanElements.get(0).getText());
            /*for(WebElement spanElement: spanElements) {
                span1Text = spanElement.getText();
                if(span1Text.isEmpty()) {
                    span1Text = (String) ((JavascriptExecutor) webDriver).executeScript("return arguments[0].textContent.trim();", spanElement);
                }
                System.out.println(span1Text);
            }*/

        }

        File file = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("result.png"));
        Thread.sleep(5000);
        autoList.get(0).click();
    }

    @BeforeMethod
    public void openBrowser() {
        ChromeOptions chromeOptions =  new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser() {
        webDriver.quit();
    }
}

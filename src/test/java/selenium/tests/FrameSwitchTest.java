package selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FrameSwitchTest {

    WebDriver webDriver;

    @Test
    public void frameSwitch() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://demoqa.com/frames");

        // Locate all iframes on the page
        //By Index: If the frame is the nth frame on the page.
        //By Name or ID: If the frame has a name or id attribute.
        //By WebElement: If the frame is identified by some element within it.
        //By Locator: If you can locate the frame using an XPath or CSS selector.
        List<WebElement> iframes = webDriver.findElements(By.xpath("//div[@id='framesWrapper']//iframe"));
        System.out.println(iframes.size());
        for (WebElement iframe : iframes) {
            System.out.println(iframe.getSize().width);
            webDriver.switchTo().frame(iframe);
            //System.out.println(webDriver.findElement(By.tagName("h1")).getText());
            webDriver.switchTo().defaultContent();
        }


    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}

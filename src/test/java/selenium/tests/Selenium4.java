package selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class Selenium4 {
    @Test
    public void useWindowTab() {
        WebDriver webDriver = new ChromeDriver();
        try {

            Set<String> allWindows = webDriver.getWindowHandles();
            String mainWindow = webDriver.getWindowHandle();
            // Open the first URL
            webDriver.get("https://www.google.com");
            System.out.println("First Window Title: " + webDriver.getTitle());
            // Open a new tab and switch to it
            WebDriver newTab = webDriver.switchTo().newWindow(WindowType.TAB);
            newTab.get("https://www.bing.com");
            System.out.println("New Tab Title: " + newTab.getTitle());

            // Open a new window and switch to it
            WebDriver newWindow = webDriver.switchTo().newWindow(WindowType.WINDOW);
            newWindow.get("https://www.yahoo.com");
            System.out.println("New Window Title: " + newWindow.getTitle());
        } finally {
            webDriver.quit();
        }

    }
}

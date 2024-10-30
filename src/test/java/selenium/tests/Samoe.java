package selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Samoe {

    @Test
    public void testa() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com/login");
    }
}

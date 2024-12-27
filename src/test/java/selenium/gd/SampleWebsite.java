package selenium.gd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SampleWebsite {
    WebDriver webDriver;

    @BeforeMethod
    public void openBrowser() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
    }


    @Test
    public void validateSubCategory() {
        webDriver.get("https://www.flipkart.com/");
        String category = "Fashion";
        String subCategory = "Women Footwear";
        String subCategory2 = "Women Heels";
        String sortOrder = "Price -- Low to High";
        webDriver.findElement(By.xpath("//span[text()='" + category + "']")).click();
        selectSubCategories(subCategory, subCategory2);
        clickSortOrderType(sortOrder);
        System.out.println("----");

    }

    private void clickSortOrderType(String sortOrder) {
        WebElement sortBy = webDriver.findElement(By.xpath("//div[text()='" + sortOrder + "']"));
        sortBy.click();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        WebElement firstPriceElement = webDriver.findElement(By.xpath("//div[@data-id]//div[@class='Nx9bqj']"));
        webDriverWait.until(ExpectedConditions.stalenessOf(firstPriceElement));
        List<WebElement> allPrices = webDriver.findElements(By.xpath("//h1[text()=\"Women's Heels\"]/ancestor::div[3]/following-sibling::div//div[@data-id]//div[@class='Nx9bqj']"));
        List<Integer> listOfPrices = allPrices.stream()
                .map(WebElement::getText)
                .map(price -> price.replaceAll("[₹,]", ""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int priceOfFirst = listOfPrices.get(0);
        //Validate Sorting
        Collections.sort(listOfPrices);
        Assert.assertEquals(priceOfFirst, listOfPrices.get(0));

    }

    private void selectSubCategories(String subCategory, String subCategory2) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.linkText(subCategory))).perform();
        actions.moveToElement(webDriver.findElement(By.linkText(subCategory2))).click().perform();
    }


    @AfterMethod
    public void closeBrowser() {
        webDriver.quit();
    }
}

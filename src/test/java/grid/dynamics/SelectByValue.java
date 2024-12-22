package grid.dynamics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;

public class SelectByValue {
    WebDriver webDriver;

    public void selectValueFromDropdown(String xpath, String value) {
        boolean found = false;
        Select selectDropdown = new Select(webDriver.findElement(By.xpath(xpath)));
        List<WebElement> options = selectDropdown.getOptions();
        for (WebElement option : options) {
            if (value.equals(option.getText())) {
                found = true;
                option.click();
                //selectDropdown.selectByVisibleText(value);
                break;
            }
        }
        if (!found) {
            //Throw
            throw new NoSuchElementException("No element found with value: " + value);
        }
    }
}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    WebDriver driver;

    // PageFactory locators (elements on the login page)
    @FindBy(xpath = "//select[@id='country1']")
    WebElement source;

    @FindBy(xpath = "//select[@id='country2']")
    WebElement destination;

    // Constructor to initialize elements with PageFactory
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Action methods
    public List<String> getSelectOptionsSource() {
        return getSelectOptions(this.source);
    }

    public List<String> getSelectOptionsDestination() {
        return getSelectOptions(this.destination);
    }

    public List<String> getSelectOptions(WebElement webElement) {
        List<String> list = new ArrayList<String>();
        Select select = new Select(webElement);
        List<WebElement> list1 = select.getOptions();
        for(WebElement we: list1) {
            list.add(we.getText());
        }
        return list;
    }



    // Combined action (optional)

}

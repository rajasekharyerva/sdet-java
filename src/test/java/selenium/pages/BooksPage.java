package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BooksPage extends BasePage{

    private WebDriver driver;

    // Web Elements
    @FindBy(id = "searchBox")
    private WebElement searchText;

    @FindBy(xpath = "//input[@type='number']")
    private WebElement pageText;

    @FindBy(xpath = "//select[@aria-label='rows per page']")
    private WebElement rowsDropdown;

    @FindBy(xpath = "//div[@class='rt-tbody']/div[@role='rowgroup']")
    private List<WebElement> rows;

    @FindBy(xpath = "//button[text()='Previous']")
    private WebElement previousButton;

    @FindBy(xpath = "//button[text()='Next']")
    private WebElement nextButton;

    // Constructor
    public BooksPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void enterSearchText(String text) {
        searchText.clear();
        searchText.sendKeys(text);
    }

    public void selectPage(String page) {
        pageText.sendKeys(page);
        pause(10000);
    }

    public void selectRows(String rows) {
        Select selectRows = new Select(rowsDropdown);
        selectRows.selectByVisibleText(rows);
        pause(1000);
    }

    public void displayResults() {
        for(WebElement rowWE: rows) {
            List<WebElement> cols = rowWE.findElements(By.xpath(".//div[@class='rt-td']"));
            if (rowWE.getText().trim().isEmpty()) {
                // Skip this row if it has no text
                continue;
            }
            for(WebElement colWE: cols) {
                System.out.print(colWE.getText()+"\t");
            }
            System.out.println("\n");
        }
    }

    // Example method to get details from the table
    public void printTableDetails() {
        // Logic to iterate through table rows and fetch image, title, author, and publisher
    }
}


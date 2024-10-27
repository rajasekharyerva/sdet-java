package selenium.pages;

import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Listeners({AllureTestNg.class})
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

    @FindBy(xpath = "//div[contains(@class,'rt-tr')]/div[@role='columnheader']")
    private List<WebElement> rowsHeaders;

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
    @Step("Entering book name {text}")
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

    public List<String> getRowHeaders() {
        List<String> columnNames = new ArrayList<>();
        for(WebElement rowHeader: rowsHeaders) {
            columnNames.add(rowHeader.getText());
        }
        return columnNames;
    }

    public List<Map<String, String>> getTableRowData() {
        List<String> columnHeaders = getRowHeaders();
        // List to store all row data
        List<Map<String, String>> tableData = new ArrayList<>();
        for(WebElement rowWE: rows) {
            Map<String, String> rowData = new HashMap<>();
            List<WebElement> colDataWE = rowWE.findElements(By.xpath(".//div[@class='rt-td']"));
            if (rowWE.getText().trim().isEmpty()) {
                // Skip this row if it has no text
                continue;
            }
            for(int i = 0; i < colDataWE.size(); i++) {
                rowData.put(columnHeaders.get(i), colDataWE.get(i).getText());
            }
            tableData.add(rowData);
        }
        return tableData;
    }

    // Example method to get details from the table
    public void printTableDetails() {
        // Logic to iterate through table rows and fetch image, title, author, and publisher
    }
}


package selenium.tests;

import io.qameta.allure.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.pages.BooksPage;

import java.util.List;
import java.util.Map;

@Feature("Books Search")
public class BooksTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BooksTest.class);

    @Test(description = "TC3-Register User", groups = "sanity")
    public void fillForm() {
        // Create FormPage, Faker instance
        BooksPage booksPage = new BooksPage(driver);

       /* booksPage.selectRows("5 rows");
        booksPage.selectPage("2");*/
        String searchTxt = "Cierra";
        booksPage.enterSearchText(searchTxt);
        List<Map<String, String>> tableData = booksPage.getTableRowData();
        for(Map<String, String> map: tableData) {
            Assert.assertEquals(map.get("First Name"), searchTxt);
        }


    }
}

package selenium.tests;

import io.qameta.allure.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.pages.BooksPage;

import java.util.List;
import java.util.Map;

//@Listeners({AllureTestNg.class, CustomTestListener.class})
public class BooksTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BooksTest.class);

    @Test(description = "TC3-Register User", groups = "sanity")
    @Feature("Books Search")
    public void fillForm() {
        // Create FormPage, Faker instance
        BooksPage booksPage = new BooksPage(driver);

       /* booksPage.selectRows("5 rows");
        booksPage.selectPage("2");*/
        String searchTxt = "Cierra";
        //test.log(Status.INFO, "Navigating to Google");
        booksPage.enterSearchText(searchTxt);
        List<Map<String, String>> tableData = booksPage.getTableRowData();
        for (Map<String, String> map : tableData) {
            Assert.assertEquals(map.get("First Name"), searchTxt);
        }


    }

    @Test(description = "TC3-Register User", groups = "sanity")
    @Feature("Books Search2")
    public void fillForm2() {

    }
}

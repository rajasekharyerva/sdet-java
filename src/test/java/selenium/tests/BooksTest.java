package selenium.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import selenium.pages.BooksPage;

public class BooksTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BooksTest.class);

    @Test(description = "TC3-Register User", groups = "sanity")
    public void fillForm() {
        // Create FormPage, Faker instance
        BooksPage booksPage = new BooksPage(driver);

       /* booksPage.selectRows("5 rows");
        booksPage.selectPage("2");
        booksPage.enterSearchText("Eric Elliott");*/
        booksPage.displayResults();


    }
}

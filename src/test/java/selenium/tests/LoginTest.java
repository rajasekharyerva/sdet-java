package selenium.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import selenium.pages.LoginPage;
import selenium.utilities.ExcelUtility;

public class LoginTest extends BaseTest{
    private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);

    @Test(description = "TC4-Login Test", groups = "sanity")
    public void fillForm(){
        // Create Login, read user info from Excel
        LoginPage loginPage = new LoginPage(driver);
        String[] userInfo = ExcelUtility.reader();
        loginPage.enterUsername(userInfo[0]);
        loginPage.enterPassword(userInfo[1]);
        loginPage.clickLoginButton();
    }
}

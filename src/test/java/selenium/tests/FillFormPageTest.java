package selenium.tests;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import selenium.pages.FormPage;
import selenium.utilities.Utils;


public class FillFormPageTest extends BaseTest{
    private static final Logger logger = LoggerFactory.getLogger(FillFormPageTest.class);

    @Test(description = "TC2-Fill Form", groups = "sanity")
    public void fillForm(){
        // Create FormPage, Faker instance
        FormPage formPage = new FormPage(driver);
        Faker faker = new Faker();

        formPage.enterFirstName(faker.name().firstName());
        formPage.enterLastName(faker.name().lastName());
        formPage.selectGender(Utils.selectRandomGender());
        formPage.enterMobile(String.valueOf(faker.phoneNumber().cellPhone().replace("-", "")));
        formPage.clickSubmit();
        formPage.clickClose();

    }
}

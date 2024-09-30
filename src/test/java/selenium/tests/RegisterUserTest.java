package selenium.tests;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import selenium.pages.RegisterPage;

public class RegisterUserTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(RegisterUserTest.class);

    @Test(description = "TC3-Register User", groups = "sanity")
    public void fillForm() {
        // Create FormPage, Faker instance
        RegisterPage registerPage = new RegisterPage(driver);
        Faker faker = new Faker();

        registerPage.enterFirstName(faker.name().firstName());
        registerPage.enterLastName(faker.name().lastName());
        registerPage.enterUsername(faker.name().username());
        registerPage.enterPassword(faker.internet().password(8, 16));
        // Blocker Image captcha
        registerPage.solveRecaptcha();
        registerPage.clickRegister();

    }
}
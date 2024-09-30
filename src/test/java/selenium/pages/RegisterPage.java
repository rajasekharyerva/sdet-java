package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage{
    private WebDriver driver;

    // Constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize the PageFactory
    }

    // Web Elements
    @FindBy(id = "firstname")
    private WebElement firstNameField;

    @FindBy(id = "lastname")
    private WebElement lastNameField;

    @FindBy(id = "userName")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//iframe[@title='reCAPTCHA']")
    private WebElement iframeCaptcha;


    @FindBy(css = "div.recaptcha-checkbox-border")
    private WebElement recaptchaElement;

    @FindBy(id = "gotologin")
    private WebElement backToLoginButton;

    @FindBy(id = "register")
    private WebElement registerButton;

    // Actions
    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickRegister() {
        registerButton.click();
        pause(1000);
    }

    public void clickBackToLogin() {
        backToLoginButton.click();
    }

    // Method to interact with reCAPTCHA (if applicable)
    public void solveRecaptcha() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iframeCaptcha);
        driver.switchTo().frame(iframeCaptcha);
        driver.findElement(By.cssSelector("div.recaptcha-checkbox-border")).click();
        pause(1000);
        driver.switchTo().defaultContent();
    }
}


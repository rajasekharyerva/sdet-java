package selenium.pages;

import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;

@Listeners({AllureTestNg.class})
public class FormPage extends BasePage {

    WebDriver driver;

    // Constructor to initialize the driver and elements
    public FormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Name field
    @FindBy(id = "firstName")
    private WebElement firstnameTextBox;

    // Name field
    @FindBy(id = "lastName")
    private WebElement lastNameTextBox;

    // Email field
    @FindBy(id = "userEmail")
    private WebElement emailTextBox;

    // Gender radio buttons
    @FindBy(css = "label[for='gender-radio-1']")
    private WebElement genderMaleRadioButton;

    @FindBy(css = "label[for='gender-radio-2']")
    private WebElement genderFemaleRadioButton;

    @FindBy(css = "label[for='gender-radio-3']")
    private WebElement genderOtherRadioButton;

    // Mobile field
    @FindBy(id = "userNumber")
    private WebElement mobileTextBox;

    // Date of Birth field
    @FindBy(id = "dob")
    private WebElement dobTextBox;

    // Subjects field
    @FindBy(id = "subjects")
    private WebElement subjectsTextBox;

    // Hobbies checkboxes
    @FindBy(id = "hobbies-sports")
    private WebElement hobbiesSportsCheckbox;

    @FindBy(id = "hobbies-reading")
    private WebElement hobbiesReadingCheckbox;

    @FindBy(id = "hobbies-music")
    private WebElement hobbiesMusicCheckbox;

    // Current Address field
    @FindBy(id = "currentAddress")
    private WebElement currentAddressTextBox;

    // State dropdown
    @FindBy(id = "state")
    private WebElement stateDropdown;

    // City dropdown
    @FindBy(id = "city")
    private WebElement cityDropdown;

    // Submit button
    @FindBy(id = "submit")
    private WebElement submitButton;

    // Success Text
    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement successText;

    // Close button
    @FindBy(id = "closeLargeModal")
    private WebElement closeButton;

    // Methods to interact with fields

    // Enter First Name
    @Step("Entering first name :{name}")
    public void enterFirstName(String name) {
        firstnameTextBox.sendKeys(name);
        pause(1000);
    }

    // Enter First Name
    public void enterLastName(String name) {
        lastNameTextBox.sendKeys(name);
        pause(1000);
    }

    // Enter Email
    public void enterEmail(String email) {
        emailTextBox.sendKeys(email);
    }

    // Select Gender
    public void selectGender(String gender) {
        switch (gender.toLowerCase()) {
            case "male":
                genderMaleRadioButton.click();
                break;
            case "female":
                genderFemaleRadioButton.click();
                break;
            case "other":
                genderOtherRadioButton.click();
                break;
        }
        pause(1000);
    }

    // Enter Mobile Number
    public void enterMobile(String mobile) {
        mobileTextBox.sendKeys(mobile);
        //driver.findElement(RelativeLocator.with(By.xpath(" //label[text()='Mobile']")).toLeftOf(mobileTextBox)).click();
        pause(1000);
    }

    // Enter Date of Birth
    public void enterDob(String dob) {
        dobTextBox.sendKeys(dob);
    }

    // Enter Subjects
    public void enterSubjects(String subjects) {
        subjectsTextBox.sendKeys(subjects);
    }

    // Select Hobbies
    public void selectHobby(String hobby) {
        switch (hobby.toLowerCase()) {
            case "sports":
                hobbiesSportsCheckbox.click();
                break;
            case "reading":
                hobbiesReadingCheckbox.click();
                break;
            case "music":
                hobbiesMusicCheckbox.click();
                break;
        }
    }

    // Enter Current Address
    public void enterCurrentAddress(String address) {
        currentAddressTextBox.sendKeys(address);
    }

    // Select State from dropdown
    public void selectState(String state) {
        Select select = new Select(stateDropdown);
        select.selectByVisibleText(state);
    }

    // Select City from dropdown
    public void selectCity(String city) {
        Select select = new Select(cityDropdown);
        select.selectByVisibleText(city);
    }

    // Click the Submit button
    public void clickSubmit() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        submitButton.click();
        //pause(1000);
    }

    // Click the Close button
    public void clickClose()  {
        closeButton.click();
        //pause(1000);
    }

}


package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import base.BaseTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class PatientRegistrationTest extends BaseTest {

    WebDriver driver;

    @FindBy(id = "referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")
    private WebElement registerButton;

    @FindBy(name = "givenName")
    private WebElement givenNameField;

    @FindBy(name = "middleName")
    private WebElement middleNameField;

    @FindBy(name = "familyName")
    private WebElement familyNameField;

    @FindBy(id = "next-button")
    private WebElement nextButton;

//    @FindBy(id = "gender-field")
//    private WebElement genderDropdown;

    @FindBy(xpath = "//select[@id='gender-field']/option[@value='M']")
    private WebElement male;

    @FindBy(xpath = "//select[@id='gender-field']/option[@value='F']")
    private WebElement female;

    @FindBy(id = "checkbox-unknown-patient")
    private WebElement checkBoxButton;

    @FindBy(id = "birthdateDay-field")
    private WebElement dayField;

    @FindBy(id = "birthdateMonth-field")
    private WebElement monthField;

    @FindBy(xpath = "//select[@id='birthdateMonth-field']/option[@value='6']")
    private WebElement monthOption;

    @FindBy(id = "birthdateYear-field")
    private WebElement yearField;

    @FindBy(id = "address1")
    private WebElement address1;

    @FindBy(id = "address2")
    private WebElement address2;

    @FindBy(id = "cityVillage")
    private WebElement city;

    @FindBy(id = "stateProvince")
    private WebElement state;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "postalCode")
    private WebElement postal;

    @FindBy(name = "phoneNumber")
    private WebElement phoneNumberField;

    @FindBy(id = "submit")
    private WebElement confirmButton;

    @FindBy(id = "confirmation-message")
    private WebElement confirmationMessage;

    public PatientRegistrationTest(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @Test(priority = 0)
    public void registerNewPatient() {

        System.out.println("Test Case 1 of Register a patient");
        registerButton.click();

        Assert.assertNotNull(registerButton, "Register button is not initialized.");

        System.out.println("1st Field of 1st section");
        givenNameField.sendKeys("Shanti");
        middleNameField.sendKeys("Devi");
        familyNameField.sendKeys("Raman");

        clickNextButton();
        System.out.println("Name filled");


        selectGender("Female");
        clickNextButton();
        System.out.println("Gender clicked");


        enterBirthdate("15", "1994");
        clickNextButton();
        System.out.println("Birthdate selected");

        address1.sendKeys("L-11");
        address2.sendKeys("NSEZ");
        city.sendKeys("Noida");
        state.sendKeys("Delhi");
        country.sendKeys("India");
        postal.sendKeys("301201");
        clickNextButton();
        System.out.println("Address filled");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(phoneNumberField));
        phoneNumberField.sendKeys("1234567890");
        clickNextButton();
        System.out.println("phone number clicked");

        clickNextButton();
        System.out.println("Relatives clicked");

        confirmButton.click();
        System.out.println("Confirmation clicked");

    }

    @Test(priority = 1)
    public void registerPatientWithMinimumInfo() {

        System.out.println("Test Case 2 of Register a patient");
        registerButton.click();

        Assert.assertNotNull(registerButton, "Register button is not initialized.");

        System.out.println("1st Field of 1st section");
        givenNameField.sendKeys("Shakuntala");
        System.out.println("2nd Field of 1st section");
        middleNameField.sendKeys("Devi");
        System.out.println("3rd Field of 1st section");
        familyNameField.sendKeys("Tiwari");
        clickNextButton();
        System.out.println("Name filled");

        selectGender("Female");
        clickNextButton();
        System.out.println("Gender clicked");


        enterBirthdate("15", "1994");
        clickNextButton();
        System.out.println("Birthdate selected");

        address1.sendKeys("L-11");
        clickNextButton();

        phoneNumberField.sendKeys("");
        clickNextButton();
        System.out.println("phone number clicked");

        clickNextButton();
        System.out.println("Relatives clicked");

        confirmButton.click();
        System.out.println("Confirmation clicked");

//        WebElement errorElement = findErrorElement();
//        Assert.assertNotNull(errorElement, "Error message element not found");
//        String classAttributeValue = errorElement.getAttribute("class");
//        Assert.assertTrue(classAttributeValue.contains("field-error"), "Error message does not have the expected class 'field-error'");
    }

    @Test(priority = 1)
    public void registerPatientWitUnidentifiedUser() {

        System.out.println("Test Case 2 of Register a patient");
        registerButton.click();

        Assert.assertNotNull(registerButton, "Register button is not initialized.");

//        System.out.println("1st Field of 1st section");
//        givenNameField.sendKeys("Shakuntala");
//        System.out.println("2nd Field of 1st section");
//        middleNameField.sendKeys("Devi");
//        System.out.println("3rd Field of 1st section");
//        familyNameField.sendKeys("Tiwari");
        checkBoxButton.click();
        clickNextButton();
        System.out.println("Name filled");

        selectGender("Female");
        clickNextButton();
        System.out.println("Gender clicked");


        enterBirthdate("15", "1994");
        clickNextButton();
        System.out.println("Birthdate selected");

        address1.sendKeys("L-11");
        clickNextButton();

        phoneNumberField.sendKeys("");
        clickNextButton();
        System.out.println("phone number clicked");

        clickNextButton();
        System.out.println("Relatives clicked");

        confirmButton.click();
        System.out.println("Confirmation clicked");

//        WebElement errorElement = findErrorElement();
//        Assert.assertNotNull(errorElement, "Error message element not found");
//        String classAttributeValue = errorElement.getAttribute("class");
//        Assert.assertTrue(classAttributeValue.contains("field-error"), "Error message does not have the expected class 'field-error'");
    }


    private WebElement findErrorElement() {
        try {

            return driver.findElement(By.cssSelector("p.left"));
        } catch (NoSuchElementException e) {
            return null;
        }
    }


    private void clickNextButton() {
        nextButton.click();
    }

    private void selectGender(String gender) {
        if (gender.equalsIgnoreCase("Male")) {
            male.click();
        } else if (gender.equalsIgnoreCase("Female")) {
            female.click();
        } else {
            throw new IllegalArgumentException("Invalid gender: " + gender);
        }
    }

    private void enterBirthdate(String day, String year) {
        dayField.sendKeys(day);
        System.out.println("Birth Date filled");

        monthField.click();
        monthOption.click();
        System.out.println("Birth Month filled");

        yearField.sendKeys(year);
        System.out.println("Birth Year filled");
    }
}

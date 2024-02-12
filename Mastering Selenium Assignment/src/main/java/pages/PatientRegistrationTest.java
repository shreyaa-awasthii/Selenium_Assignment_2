package pages;

import org.testng.Assert;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static java.sql.DriverManager.getDriver;

public class PatientRegistrationTest extends BaseTest{
    @Test
    public void registerNewPatient() {
        // Click on "Register a patient" button
        WebElement registerButton = getDriver().findElement(By.id("registration-link"));
        registerButton.click();

        // Step 1: Enter Given Name, Middle Name, and Family Name then click on next button
        fillFormField("givenName", "John");
        fillFormField("middleName", "Doe");
        fillFormField("familyName", "Smith");
        clickNextButton();

        // Step 2: Select Gender (Male/Female) then click on next button
        selectGender("Male");
        clickNextButton();

        // Step 3: Enter the complete Birthdate (Day, Month, Year) or Estimated Years and Estimated Months then click on next button
        enterBirthdate("15", "Feb", "1990");
        clickNextButton();

        // Step 4: Skip Address Section by clicking on next button
        clickNextButton();

        // Step 5: Fill phone number and click next button
        fillFormField("phoneNumber", "1234567890");
        clickNextButton();

        // Step 6: Skip Relatives section by clicking next
        clickNextButton();

        // Step 7: Click on the "Confirm" button
        WebElement confirmButton = getDriver().findElement(By.id("submit"));
        confirmButton.click();

        // Assert confirmation message
        WebElement confirmationMessage = getDriver().findElement(By.id("confirmation-message"));
        Assert.assertTrue(confirmationMessage.isDisplayed(), "Patient registration confirmation message not displayed.");
    }

    private void fillFormField(String fieldName, String value) {
        WebElement field = getDriver().findElement(By.id(fieldName));
        field.sendKeys(value);
    }

    private void clickNextButton() {
        WebElement nextButton = getDriver().findElement(By.id("next-button"));
        nextButton.click();
    }

    private void selectGender(String gender) {
        WebElement genderDropdown = getDriver().findElement(By.id("gender-field"));
        genderDropdown.click();
        WebElement genderOption = getDriver().findElement(By.xpath("//div[@id='gender-field-listbox']/div[contains(text(), '" + gender + "')]"));
        genderOption.click();
    }

    private void enterBirthdate(String day, String month, String year) {
        WebElement dayField = getDriver().findElement(By.id("day"));
        WebElement monthField = getDriver().findElement(By.id("month"));
        WebElement yearField = getDriver().findElement(By.id("year"));

        dayField.sendKeys(day);
        monthField.sendKeys(month);
        yearField.sendKeys(year);
    }
}

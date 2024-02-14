package test;
import base.BaseTest;
import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PatientRegistrationTest;
import pages.SignInPage;

import java.time.Duration;

public class TestScenario {

    private WebDriver driver;
    private BaseTest baseTest;
    private SignInPage signInPage;
    private PatientRegistrationTest patientRegistrationTest;

    @BeforeMethod
    public void setUp() {
        baseTest = new BaseTest();
        baseTest.setUp();
        driver = baseTest.getDriver();
        //driver = baseTest.initializeDriver(new Config("chrome", "https://demo.openmrs.org/openmrs/"));
        signInPage = new SignInPage(driver);
        patientRegistrationTest = new PatientRegistrationTest(driver);
    }

    @Test
    public void testPatientRegistration() {
        signInPage.signIn("Admin", "Admin123");
         //patientRegistrationTest.registerNewPatient();
        //patientRegistrationTest.registerPatientWithMinimumInfo();
        patientRegistrationTest.registerPatientWitUnidentifiedUser();
    }

    @AfterMethod
    public void tearDown() {
        baseTest.tearDown();
    }
}

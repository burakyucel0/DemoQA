package tests;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.BasePage;
import pages.FormPage;

public class FormAutomationTest extends BasePage {
    private static FormPage formPage;

    @BeforeClass
    public static void setUpTest() {
        setUp();
        formPage = new FormPage(driver);
    }

    @Test
    public void testFormSubmission() {
        formPage.openForm();
        formPage.fillForm();
        formPage.submitForm();
    }

    @AfterClass
    public static void tearDownTest() {
        tearDown();
    }
}
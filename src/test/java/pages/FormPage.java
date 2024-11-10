package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FormPage extends BasePage {
    private final By firstNameField = By.id("firstName");
    private final By lastNameField = By.id("lastName");
    private final By emailField = By.id("userEmail");
    private final By genderRadio = By.xpath("//label[text()='Male']");
    private final By mobileField = By.id("userNumber");
    private final By dobField = By.id("dateOfBirthInput");
    private final By subjectField = By.id("subjectsInput");
    private final By hobbyCheckbox = By.xpath("//label[text()='Sports']");
    private final By uploadPicture = By.id("uploadPicture");
    private final By currentAddressField = By.id("currentAddress");
    private final By submitButton = By.id("submit");

    public FormPage(WebDriver driver) {
        BasePage.driver = driver;
    }

    public void openForm() {
        driver.get("https://demoqa.com/automation-practice-form");
    }

    public void fillForm() {
        driver.findElement(firstNameField).sendKeys("John");
        driver.findElement(lastNameField).sendKeys("Doe");
        driver.findElement(emailField).sendKeys("john.doe@example.com");
        driver.findElement(genderRadio).click();
        driver.findElement(mobileField).sendKeys("1234567890");

        // Open date of birth picker
        driver.findElement(dobField).click();

        // Select the year (1996)
        WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
        yearDropdown.click();
        WebElement yearOption = driver.findElement(By.xpath("//option[@value='1996']"));
        yearOption.click();

        // Select the month (August)
        WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
        monthDropdown.click();
        WebElement monthOption = driver.findElement(By.xpath("//option[@value='7']")); // August is index 7
        monthOption.click();

        // Select the day (23)
        WebElement day = driver.findElement(By.xpath("//div[contains(@class, 'react-datepicker__day') and text()='23']"));
        day.click();

        WebElement subjectsInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("subjectsInput")));

        // Type "a" to trigger the dropdown options
        subjectsInput.sendKeys("a");

        // Wait until "Maths" option is visible and clickable, then select it
        WebElement mathsOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='react-select-2-option-0' and text()='Maths']")));
        mathsOption.click();

        driver.findElement(hobbyCheckbox).click();
        driver.findElement(uploadPicture).sendKeys("/Users/burakyucel/Downloads/1.jpg");
        driver.findElement(currentAddressField).sendKeys("123 Main St, Anytown");

        WebElement element = driver.findElement(By.id("state"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

        // Find the "Haryana" option and select it
        WebElement haryanaOption = driver.findElement(By.xpath("//div[text()='Haryana']"));
        haryanaOption.click();

        // Wait for the city dropdown to be visible
        WebElement cityDropdown = driver.findElement(By.id("city"));

        // Click on the city dropdown to open the list
        cityDropdown.click();

        // Find the "Karnal" option and select it
        WebElement karnalOption = driver.findElement(By.xpath("//div[text()='Karnal']"));
        karnalOption.click();

    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }
}
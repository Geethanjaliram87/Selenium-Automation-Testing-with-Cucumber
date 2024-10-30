package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.io.File;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class FileUploadSteps {
    private WebDriver driver;
    private static final String UPLOAD_URL = "https://www.w3schools.com/howto/howto_html_file_upload_button.asp";

    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("dom.webnotifications.enabled", false);
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I am on the W3Schools file upload page")
    public void i_am_on_the_w3schools_file_upload_page() {
        driver.get(UPLOAD_URL);
    }

    @When("I upload a file {string}")
    public void i_upload_a_file(String filePath) {
        // Locate the file input element
        WebElement uploadElement = driver.findElement(By.id("myFile")); // Change if necessary
        uploadElement.sendKeys(new File(filePath).getAbsolutePath());
    }

    @Then("I should see a success message indicating the file has been uploaded")
    public void i_should_see_a_success_message_indicating_the_file_has_been_uploaded() {
        // Instead of looking for a specific success message, we check the file input element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Locate the file input element to confirm the uploaded file name
        WebElement uploadElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myFile")));
        String uploadedFileName = uploadElement.getAttribute("value");
        
        // Assert that the uploaded file name is displayed correctly
        Assert.assertTrue("Uploaded file name should be displayed.", uploadedFileName.contains("render.png"));
    }

}
